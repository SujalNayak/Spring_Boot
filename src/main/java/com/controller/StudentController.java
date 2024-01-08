package com.controller;

import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.StudentBean;

@RestController
public class StudentController {
	
	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody StudentBean studentBean) {
		
		
		return ResponseEntity.ok(studentBean);
	}
	@PostMapping("/studentlogin")
	public ResponseEntity<?> studentLogin(@RequestBody StudentBean studentBean) {
		
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(studentBean);
	}

}
