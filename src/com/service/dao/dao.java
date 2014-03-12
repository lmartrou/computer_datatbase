package com.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.service.om.*;

public class dao {

	public List<Computer> getListComputer(Connection cn) {

		ArrayList<Computer> listeComputeur  = new ArrayList<Computer>();
		ResultSet rs = null ;
		Statement stmt = null;

		try {

			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT computer.id,computer.name,computer.introduced,computer.discontinued,computer.company_id FROM computer");

			while (rs.next()) {
				
				
				
				Computer p =  new Computer();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setIntroduced(rs.getDate(3));
				p.setDiscontinued(rs.getDate(4));
				p.setCompany(rs.getInt(5));

				listeComputeur.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)

					rs.close();

				if (stmt != null)

					stmt.close();

				
			} catch (SQLException e) {}
		}

		return listeComputeur;
	}


	public void insereComputer(Computer computer, Connection cn) {

		ResultSet rs = null ;
		PreparedStatement stmt = null;

		try {

			stmt = cn.prepareStatement("INSERT into Computeur(name, introduced,discontinued,compagny_id) VALUES(?,?,?,?);");

		
			stmt.setString(1,computer.getName());
			stmt.setDate(2,(java.sql.Date) computer.getIntroduced());
			stmt.setDate(3,(java.sql.Date) computer.getDiscontinued());
			stmt.setLong(4,computer.getCompany());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)

					rs.close();

				if (stmt != null)

					stmt.close();

			} catch (SQLException e) {}
		}
	}
	
	public List<Company> getListCompany(Connection cn) {

		ArrayList<Company> listeCompany  = new ArrayList<Company>();
		ResultSet rs = null ;
		Statement stmt = null;

		try {

			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT id, name FROM company");
			while (rs.next()) {
				Company c =  new Company();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				
				listeCompany.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)

					rs.close();

				if (stmt != null)

					stmt.close();

				if (cn != null) cn.close();
			} catch (SQLException e) {}
		}

		return listeCompany;
	}


	public void insereCompany(Company company, Connection cn) {

		ResultSet rs = null ;
		PreparedStatement stmt = null;

		try {

			stmt = cn.prepareStatement("INSERT into Company(id, name) VALUES(?,?,?,?,?);");

			stmt.setInt(1,company.getId());
			stmt.setString(2,company.getName());
			
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)

					rs.close();

				if (stmt != null)

					stmt.close();

				
			} catch (SQLException e) {}
		}
	}
}

