package com.employee.hibernate.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.employee.hibernate.bean.SalaryCount;
import com.employee.hibernate.bean.SalaryCountResultTransformer;
import com.employee.hibernate.pojo.Employee;
import com.employee.hibernate.utils.HibernateUtils;


public class EmployeeDao implements IEmployeeDao{
	SessionFactory sf;
	final static Logger logger = Logger.getLogger(EmployeeDao.class);
	
	public EmployeeDao() {
		sf = HibernateUtils.getSessionFactory();
	}

	public void createEmployee(Employee employee) throws EmployeeCreationException {
		logger.debug("Executing EmployeeDao::createEmployee API" + employee.getId());
    	sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        try {
			session.save(employee);
		} catch (Exception e) {
			logger.error("failed to execute createEmployee method", e);
		}
		transaction.commit();
        session.close();
        logger.debug("Completed executing EmployeeDao::createEmployee API");
	}

	@Override
	public boolean updateEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession(); 
        Transaction transaction = session.beginTransaction();
        try{
			session.update(employee);
		}catch(Exception e){
			logger.error("failed to update", e);
			return false;
		}
        transaction.commit();
        session.close();
		return true;
	}

	@Override
	public boolean deleteEmployee(int empId) throws ClassNotFoundException, SQLException {
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee) session.load(Employee.class, empId);
		 try{
				session.delete(employee);
			}catch(Exception e){
				logger.error("failed to delete", e);
				return false;
			}
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public List<Employee> findAll() throws ClassNotFoundException, SQLException {
		sf = HibernateUtils.getSessionFactory();
        Session session = sf.openSession();  
        Transaction transaction = session.beginTransaction();
        Query query =  session.createQuery("FROM Employee");
        @SuppressWarnings("unchecked")
		List<Employee> employees = query.list();  
        transaction.commit();
        session.close();
        return employees;
	}

	public Employee findEmployee(int id) throws ClassNotFoundException, SQLException{
		sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();

		Transaction transaction = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		transaction.commit();
		session.close();
		return employee;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> sort(String criteria) throws SQLException {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> employees;
		try{
			employees = session.createCriteria(Employee.class)
					.addOrder(Order.desc(criteria))
					.list();

		}catch(Exception e){
			logger.error("failed to execute delete method", e);
			return null;
		}
		transaction.commit();
		session.close();
		return employees;
	}
	
	public Set<Employee> uniqueElements() throws ClassNotFoundException, SQLException{		
		Set<Employee> set = new HashSet<Employee>(findAll());			
		return set;
	}
	

	@Override
	public double displayGrossSal(int empId) {
		double grossSal=0;
		List<Employee> employees = null;
		try {
			employees = findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getId() == empId){
				grossSal = employees.get(i).calculateGrossSal();
				break;
			}
		}
		return grossSal;
	}

	@Override
	public double displayHRA(int empId) {
		double hra=0;
		List<Employee> employees = null;
		try {
			employees = findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		for(int i=0;i<employees.size();i++){
			if(employees.get(i).getId() == empId){
				hra = employees.get(i).calculateHRA();
				break;
			}
		}
		return hra;
	}
	
	@SuppressWarnings("unchecked")
	public List<SalaryCount> salaryWiseCount() throws ClassNotFoundException, SQLException{
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		String hqlquery = "select e.salary, count(salary) from Employee as e group by e.salary";
		
		List<SalaryCount> salaryCount;
		try{
			Query query = session.createQuery(hqlquery);
			query.setResultTransformer(new SalaryCountResultTransformer());	
			salaryCount = query.list();
			
		}catch(Exception e){
			logger.error("failed to get salary Count", e);
			System.out.println(e);
			return null;
		}
		transaction.commit();
		session.close();
		return salaryCount;
	}
}
