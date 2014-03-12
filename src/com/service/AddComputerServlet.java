package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.service.dao.dao;
import com.service.om.Computer;




 public class AddComputerServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	 
	private static final String FIELD_NAME="name",FIELD_INTRODUCED="introducedDate",FIELD_DISCONTINUED="discontinuedDate",FIELD_COMPANY="company";
	public AddComputerServlet() {
		super();
	}   	 	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Computer computer = new Computer();
		String chemin= getServletConfig().getInitParameter("CheminImages");
		
		computer.setName(request.getParameter(FIELD_NAME));
		computer.setIntroduced(Date.valueOf(request.getParameter(FIELD_INTRODUCED)));
		computer.setDiscontinued(Date.valueOf(request.getParameter(FIELD_DISCONTINUED)));
		computer.setCompany(Integer.valueOf(request.getParameter(FIELD_COMPANY)));
		
		
		Context ctx;
		try {
			ctx = new InitialContext();
			
			DataSource ds = (DataSource) ctx.lookup("java:computeur-database-db");
			dao dao = new dao();
					
			dao.insereComputer(computer, ds.getConnection());

			List list = dao.getListComputer(ds.getConnection());
					

			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}   	  	    
}