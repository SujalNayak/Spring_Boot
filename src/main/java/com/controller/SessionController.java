package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	BCryptPasswordEncoder encoder;
	
	//signup
	@PostMapping("/signup")
	public ResponseEntity<?> addUser(@RequestBody SessionBean session) {
		
		String hashPassword = encoder.encode(session.getPassword());
		session.setPassword(hashPassword); 
		
		sessionDao.addUser(session);
		System.out.println(session.getName());
		System.out.println(session.getEmail());
		System.out.println(session.getPassword());
//		return sessionBean;
		
		return ResponseEntity.status(HttpStatus.CREATED).body(session);
		
		
	}
	
	//login
//	@PostMapping("/login")
//	public SessionBean loginUser(@RequestBody SessionBean sessionBean) {
//		
//		SessionBean ss =	sessionDao.loginUser(sessionBean.getEmail(), sessionBean.getPassword());
//		
//		return ss;
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> sessionLogin(@RequestBody SessionBean session) {
		
		SessionBean ss =	sessionDao.loginUser(session.getEmail(), session.getPassword());
		if(ss == null) {
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials...");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ss);
		
	}
	
}
