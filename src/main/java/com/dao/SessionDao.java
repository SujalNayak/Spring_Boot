package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;
import com.bean.SessionBean;

@Repository
public class SessionDao {
	@Autowired
	JdbcTemplate stmt;

	public void addUser(SessionBean session) {

		stmt.update("insert into session(name, email, password) values (?,?,?)", session.getName(), session.getEmail(),
				session.getPassword());
	}

	public SessionBean loginUser(String email, String password) {
		try {
			return stmt.queryForObject("select * from session where email = ? AND password = ?",
					new BeanPropertyRowMapper<>(SessionBean.class), email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}