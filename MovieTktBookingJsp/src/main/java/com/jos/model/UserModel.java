package com.jos.model;

public class UserModel {
	int id; 
	String fname; 
	String lname; 
	String phno; 
	String email;
	public UserModel(int id, String fname, String lname, String phno, String email) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.phno = phno;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 

}
