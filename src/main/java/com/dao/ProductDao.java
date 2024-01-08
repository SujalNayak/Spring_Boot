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
@Repository
public class ProductDao {
	@Autowired
	JdbcTemplate stmt;
	
	public void addProduct(ProductBean product) {
		
		stmt.update("insert into product(name, price, qty,cty) values (?,?,?,?)", product.getName(), product.getPrice(), product.getQty(), product.getCty());
	}

	public List<ProductBean> getAllProducts() {
	    return stmt.query("select * from product", new BeanPropertyRowMapper<>(ProductBean.class));
	}

	public ProductBean getProductBeanById(int id) {
	    return stmt.queryForObject("select * from product where id = ?", new BeanPropertyRowMapper<>(ProductBean.class), id);
	}

	public int deleteProductByAll(int id) {
		try {
			return stmt.update("delete from product where id = ?", id);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (Integer) null;
	}





}