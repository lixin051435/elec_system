package com.domain;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int admin_id;
	private String name;
	private String password;
	private String emp;
	private String tel;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmp() {
		return emp;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", name=" + name + ", password="
				+ password + ", emp=" + emp + ", tel=" + tel + "]";
	}
	public Admin(int admin_id, String name, String password, String emp,
			String tel) {
		super();
		this.admin_id = admin_id;
		this.name = name;
		this.password = password;
		this.emp = emp;
		this.tel = tel;
	}
	
}
