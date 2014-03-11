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

	public List<Computeur> getListComputeur(Connection cn) {

		ArrayList<Computeur> listeComputeur  = new ArrayList<Computeur>();
		ResultSet rs = null ;
		Statement stmt = null;

		try {

			stmt = cn.createStatement();
			rs = stmt.executeQuery("SELECT computer.id,computer.name,computer.introduced,computer.discontinued,computer.company_id, company.name FROM computer INNER JOIN company WHERE ( computer.company_id = company.id)");

			while (rs.next()) {
				
				Company c=new Company();
				c.setId(new Long(rs.getLong(5)));
				c.setName(rs.getString(5));
				
				Computeur p =  new Computeur();
				p.setId(new Long(rs.getLong(1)));
				p.setName(rs.getString(2));
				p.setIntroduced(rs.getDate(3));
				p.setDiscontinued(rs.getDate(4));
				p.setCompany(c);

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


	public void insereComputeur(Computeur computeur, Connection cn) {

		ResultSet rs = null ;
		PreparedStatement stmt = null;

		try {

			stmt = cn.prepareStatement("INSERT into Computeur(name, introduced,discontinued,compagny_id) VALUES(?,?,?,?);");

		
			stmt.setString(1,computeur.getName());
			stmt.setDate(2,(java.sql.Date) computeur.getIntroduced());
			stmt.setDate(3,(java.sql.Date) computeur.getDiscontinued());
			stmt.setLong(4,computeur.getCompany().getId());

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
				c.setId(new Long(rs.getLong(1)));
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

			stmt.setLong(1,company.getId());
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

