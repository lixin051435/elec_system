package com.service;
import java.util.ArrayList;

import com.domain.Admin;
import com.domain.Elec_Info;
import com.domain.User;


public interface Service {

	ArrayList<User> getAllUsers();
	User getUserById(int user_id);
	User getUserByName(String name);
	void remove(User user);
	void add(User user);
	void update(User user);
	void removeUser(int user_id);
	
	ArrayList<Admin> getAllAdmins();
	Admin getAdminByName(String name);
	Admin getAdminById(int admin_id);
	void remove(Admin admin);
	void add(Admin admin);
	void update(Admin admin);
	
	ArrayList<Elec_Info> getAllInfos();
	Elec_Info getInfoByDate(String datetime);
	void add(Elec_Info info);
	void update(Elec_Info info);
	void remove(String datetime);
}
