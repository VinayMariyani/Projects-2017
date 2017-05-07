package com.application.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.operations.Employee;
import com.employee.operations.EmployeeJdbcOperations;
import com.employee.operations.EmployeeOperations;
import com.employee.operations.Employee.Gender;

/**
 * Servlet implementation class IdCheckServlet
 */
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmployee() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("view")){
			EmployeeOperations employeeOperations = new EmployeeJdbcOperations(); 
			response.setContentType("text/html");

			String empId = request.getParameter("empId");
			try {

				Employee employee = employeeOperations.findEmployee(Integer.parseInt(empId));
				if(employee == null){
					request.setAttribute("message", "Employee Not Found");
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}
				request.setAttribute("employee", employee);
			} 
			catch (ClassNotFoundException e) {
				request.setAttribute("message", "Employee Not Found");
			} catch (SQLException e) {
				request.setAttribute("message", "Employee Not Found");
			}
			request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);	
		}
		if(action.equals("update")) {
			EmployeeOperations employeeOperations = new EmployeeJdbcOperations(); 		
			try {
				
				String id = request.getParameter("empId");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String salary = request.getParameter("salary");
				String gender = request.getParameter("gender");
				Employee employee = new Employee();
				employee.setId(Integer.parseInt(id));
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setSalary(Double.parseDouble(salary));
				employee.setGender(Gender.valueOf(gender));
				/*Update Employee*/
				boolean flag = employeeOperations.updateEmployee(employee);
				if(flag == false){
					request.setAttribute("message", "Employee Not Found");
				}
				request.setAttribute("employee", employee);
				request.setAttribute("message", "Updated SuccessFully");
			} 
			catch (ClassNotFoundException e) {
				request.setAttribute("message", "Employee Not Found");
			} catch (SQLException e) {
				request.setAttribute("message", "Employee Not Found");
			}
			request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);	
		}
		if(action.equals("delete")) {
			EmployeeOperations employeeOperations = new EmployeeJdbcOperations(); 		
			try {
				
				String empId = request.getParameter("empId");
				
				boolean flag = employeeOperations.deleteEmployee(Integer.parseInt(empId));
				if(flag == false){
					request.setAttribute("message", "Employee Not Found");
				}
				request.setAttribute("message", "Deleted SuccessFully");
			} 
			catch (ClassNotFoundException e) {
				request.setAttribute("message", "Employee Not Found");
			} catch (SQLException e) {
				request.setAttribute("message", "Employee Not Found");
			}
			request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);	
		}		
	}

}	





