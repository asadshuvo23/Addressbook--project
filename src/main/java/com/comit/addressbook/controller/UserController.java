package com.comit.addressbook.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.comit.addressbook.service.UserService;
import com.comit.users.bean.UserBean;

import ch.qos.logback.classic.Logger;

@Controller
public class UserController {
	
//	private final Logger logger = LoggerFactory.getILoggerFactory();
	
	@Autowired
	UserService userService;
	
@GetMapping("/")
public ModelAndView index() {
	List<UserBean> users = this.userService.listUsers();
	return new ModelAndView("list", "users", users);
}

@GetMapping("/add")
public ModelAndView addContact() {
	return new ModelAndView("add");
}

@PostMapping("/addContact")
public ModelAndView addContactPost(@ModelAttribute UserBean userBean) {
	this.userService.addUser(userBean);
	return new ModelAndView("addMsg");
}

@GetMapping("/edit")
public ModelAndView updateContact(@RequestParam("employeeId") String employeeId) {
	return new ModelAndView("edit","user", this.userService.getUser(employeeId));
}

@PostMapping("/updateContact")
public ModelAndView updateContact(@ModelAttribute UserBean userBean) {
	this.userService.updateUser(userBean);
	return new ModelAndView("updateMsg");
}

@GetMapping("/deleteContact")
public ModelAndView deleteContact(@RequestParam("employeeId") int employeeId) {
	this.userService.deleteUser(employeeId);
	return new ModelAndView("deleteMsg");
		
}

@GetMapping("/findbyName")
public ModelAndView findbyName(@RequestParam("firstName") String firstName) {
	List<UserBean> users = this.userService.listuserbyFirstname(firstName);
	return new ModelAndView("list", "users", users);
}

}
