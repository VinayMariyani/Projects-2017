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

/**
 * Servlet implementation class IdCheckServlet
 */
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
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
		EmployeeOperations employeeOperations = new EmployeeJdbcOperations(); 
		response.setContentType("text/html");
		
		String empId = request.getParameter("empId");
		try {
			
			Employee employee = employeeOperations.findEmployee(Integer.parseInt(empId));
			if(employee == null){
				request.getRequestDispatcher("errorNotFound.html").forward(request, response);
			}
			request.setAttribute("employee", employee);
		} 
		catch (ClassNotFoundException e) {
			request.getRequestDispatcher("errorNotFound.html").forward(request, response);
		} catch (SQLException e) {
			request.getRequestDispatcher("errorNotFound.html").forward(request, response);
		}
		request.getRequestDispatcher("displayEmployee.jsp").forward(request, response);
	}

}
