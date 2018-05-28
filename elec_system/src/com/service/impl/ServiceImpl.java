package com.service.impl;

import java.util.ArrayList;

import com.dao.AdminDao;
import com.dao.Elec_InfoDao;
import com.dao.UserDao;
import com.domain.Admin;
import com.domain.Elec_Info;
import com.domain.User;
import com.service.Service;

public class ServiceImpl implements Service {
	private UserDao userDao = new UserDao();
	private AdminDao adminDao = new AdminDao();
	private Elec_InfoDao elec_InfoDao = new Elec_InfoDao();

	@Override
	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public User getUserById(int user_id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(user_id);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public void remove(User user) {
		// TODO Auto-generated method stub
		userDao.remove(user.getUser_id());
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public ArrayList<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminDao.getAllAdmins();
	}

	@Override
	public Admin getAdminByName(String name) {
		// TODO Auto-generated method stub
		return adminDao.getAdminByName(name);
	}

	@Override
	public Admin getAdminById(int admin_id) {
		// TODO Auto-generated method stub
		return adminDao.getAdminById(admin_id);
	}

	@Override
	public void remove(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.remove(admin.getAdmin_id());

	}

	@Override
	public void add(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.add(admin);

	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.update(admin);

	}

	public ServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void removeUser(int user_id) {
		// TODO Auto-generated method stub
		userDao.remove(user_id);
		
	}

	@Override
	public ArrayList<Elec_Info> getAllInfos() {
		return elec_InfoDao.getAllInfos();
	}

	@Override
	public Elec_Info getInfoByDate(String datetime) {
		// TODO Auto-generated method stub
		return elec_InfoDao.getInfoByDate(datetime);
	}

	@Override
	public void add(Elec_Info info) {
		// TODO Auto-generated method stub
		elec_InfoDao.add(info);
		
	}

	@Override
	public void update(Elec_Info info) {
		// TODO Auto-generated method stub
		elec_InfoDao.update(info);
		
	}

	@Override
	public void remove(String datetime) {
		// TODO Auto-generated method stub
		elec_InfoDao.remove(datetime);
		
		
	}
	

}
