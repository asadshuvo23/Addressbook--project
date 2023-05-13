package com.comit.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comit.addressbook.dao.UserDao;
import com.comit.users.bean.UserBean;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserBean> listUsers() {
		List<UserBean> users=this.userDao.listUsers();
		return users;
	}
	
	public UserBean getUser(String id) {
		return this.userDao.getUser(id);
	}
	
	public int addUser(UserBean userBean) {
		return this.userDao.addUser(userBean);
	}
	
	public int updateUser(UserBean userBean) {
		return this.userDao.updateUser(userBean);
	}
	
	public int deleteUser(long id) {
		return this.userDao.deleteById(id);
	}
	
	public List<UserBean> listuserbyFirstname(String firstname) {
		List<UserBean> users=this.userDao.listuserbyName(firstname);
		return users;
	}
}

