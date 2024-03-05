package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.services.CrudService;

@RestController
@CrossOrigin("*")
public class CrudRestController {

	@Autowired
	private CrudService service;
	 
	
	@GetMapping("/getProd")
	public List<Product> fetchProductList(){ 
		List<Product> products=new ArrayList<>();
		//Logic TO Fetch 
		 products =service.fetchProductList();
		return products;
	}
	
	@GetMapping("/getProd/{id}")
	public Product fetchProductListById(@PathVariable int id){ 
		return service.fetchProductListById(id).get();
		 
	}
	
	@PostMapping("/addProd")
	public Product saveProductList(@RequestBody Product product){ 
		
		return service.saveProductToBD(product);
		
	}
	@PostMapping("/updateProd")
	public Product updateProductList(@RequestBody Product product){ 
		System.out.println("enter");
		if(service.fetchProductListById(product.getId())!=null){
			return service.saveProductToBD(product);
		}else{

			return null;
		}
		
		
	}
	
	@DeleteMapping("/deleteProd/{id}")
	public String deleteProductListById(@PathVariable int id){ 
		return service.deleteProductListById(id);
		
	
	}
	
	
}
