package com.service;

import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

public class Service {
	
	   public static Connection con = null;
	 

	    public static Connection connect(DataSource db) throws SQLException {
	        if (con != null // if the connection exists
	             && !con.isClosed() // and has not been closed 
	             && con.isValid(0)) { // and appears to be functioning (with a test timeout of 0ms)
	             return con; // skip connection creation
	        }else{

	        // create the connection
	        con = db.getConnection(); 
	        return con;
	        }
	        
	    }

}
