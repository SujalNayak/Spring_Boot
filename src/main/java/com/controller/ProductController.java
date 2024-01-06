package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ProductBean addProduct(@RequestBody ProductBean productBean) {
				
		productDao.addProduct(productBean);
//		System.out.println(productBean.getName());
//		System.out.println(productBean.getCty());
		return productBean;
	}
	
	@GetMapping("/product")
	public List<ProductBean> getAllProducts(){
		 
		List<ProductBean> list = productDao.getAllProducts();
		return list; 
	}
	
	@GetMapping("/product/{id}") 	
	public ProductBean getProduct(@PathVariable("id") int id){
		ProductBean productbyid = productDao.getProductBeanById(id);
		return productbyid;
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable("id") int id) {
		int deletebyid = productDao.deleteProductByAll(id);
		return "...Product Deleted...";
	}
}