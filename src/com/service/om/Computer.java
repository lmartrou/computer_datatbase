package com.service.om;

import java.util.Date;



public class Computer {


	int id;
	String name;
	Date introduced;
	Date discontinued;
	int company;
	

	public Computer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getIntroduced() {
		return introduced;
	}


	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}


	public Date getDiscontinued() {
		return discontinued;
	}


	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}


	public int getCompany() {
		return company;
	}


	public void setCompany(int company) {
		this.company = company;
		
	}


	public String toString() {
		return "Computeur [id=" + id + ", name=" + name + ", introduced="
				+ introduced + ", discontinued=" + discontinued + ", company="
				+ company + "]";
	}

	


}

