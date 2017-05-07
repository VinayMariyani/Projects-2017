package com.application.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.operations.Employee;
import com.employee.operations.EmployeeJdbcOperations;
import com.employee.operations.EmployeeOperations;

/**
 * Servlet implementation class ViewAllEmployees
 */
public class ViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAll() {
        super();
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
		EmployeeOperations employeeOperations = new EmployeeJdbcOperations();
		
		try {
			List<Employee> employees = employeeOperations.findAll();
			request.setAttribute("employees", employees);
			if(employees == null){
				request.getRequestDispatcher("errorNotFound.html").forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			request.getRequestDispatcher("errorNotFound.html").forward(request, response);
		} catch (SQLException e) {
			request.getRequestDispatcher("errorNotFound.html").forward(request, response);
		}
		request.getRequestDispatcher("displayAll.jsp").forward(request, response);
	}

}
