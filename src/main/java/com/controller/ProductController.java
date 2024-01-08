package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody ProductBean productBean) {
				
		productDao.addProduct(productBean);
//		System.out.println(productBean.getName());
//		System.out.println(productBean.getCty());
		return ResponseEntity.status(HttpStatus.CREATED).body(productBean);
	}
	
	@GetMapping("/product")
	public List<ProductBean> getAllProducts(){
		 
		List<ProductBean> list = productDao.getAllProducts();
		return list; 
	}
	
	@GetMapping("/product/{id}") 	
	public ResponseEntity<?> getProduct(@PathVariable("id") int id){
		ProductBean productbyid = productDao.getProductBeanById(id);
		if(productbyid == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found...");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product Deleted Successfully...");
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable("id") int id) {
		Integer deletebyid = productDao.deleteProductByAll(id);
		if(deletebyid == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not Found...");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product Deleted Successfully...");
		
	}
}