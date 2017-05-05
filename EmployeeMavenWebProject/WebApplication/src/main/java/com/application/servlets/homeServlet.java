package com.application.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.operations.Employee;
import com.employee.operations.Employee.Gender;
import com.employee.operations.EmployeeCreationException;
import com.employee.operations.EmployeeJdbcOperations;
import com.employee.operations.EmployeeOperations;

/**
 * Servlet implementation class homeServlet
 */
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public homeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeOperations employeeOperations = new EmployeeJdbcOperations(); 
		response.setContentType("text/html");
		
		String empId = request.getParameter("empId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String salary = request.getParameter("salary");
		String gender = request.getParameter("gender");
		
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(empId));
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary( Double.parseDouble(salary));
		employee.setGender(Gender.valueOf(gender.toUpperCase()));
		
		try {
			employeeOperations.createEmployee(employee);
		} 
		catch (ClassNotFoundException e) {
			request.getRequestDispatcher("error.html").forward(request, response);
		} catch (SQLException e) {
			request.getRequestDispatcher("error.html").forward(request, response);
		} catch (EmployeeCreationException e) {
			request.getRequestDispatcher("error.html").forward(request, response);
		}
		
		response.sendRedirect("success.html");
	}

}
