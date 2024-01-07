package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.SessionBean;
import com.dao.SessionDao;

@RestController
public class SessionController {
	
	@Autowired
	SessionDao sessionDao;
	//signup
	@PostMapping("/signup")
	public SessionBean addUser(@RequestBody SessionBean sessionBean) {
		
		sessionDao.addUser(sessionBean);
		System.out.println(sessionBean.getName());
		System.out.println(sessionBean.getEmail());
		System.out.println(sessionBean.getPassword());
		return sessionBean;
	}
	
	//login
	@PostMapping("/login")
	public SessionBean loginUser(@RequestBody SessionBean sessionBean) {
		
		SessionBean ss =	sessionDao.loginUser(sessionBean.getEmail(), sessionBean.getPassword());
		
		return ss;
	}
	
}
