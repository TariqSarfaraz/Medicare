package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Login;
import com.springboot.model.Product;
import com.springboot.model.Test;
import com.springboot.service.ProductService;
import com.springboot.service.TestService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService pservice;

	// http://localhost:8686/products/productlists
	@GetMapping("/productlists") // view products admin
	public List<Product> listAllPrds() {
		return pservice.listAllPrd();
	}

	// http://localhost:8686/product/productavalist
	@GetMapping("/productavalists") // view products user
	public List<Product> ListAvaPrds() {
		return pservice.ListAvaPrd();
	}

	// http://localhost:8686/product/addProduct
	@PostMapping("/addProducts") // add product admin
	public int addProduct(@RequestBody Product product) {
		pservice.addProduct(product);
		return product.getPid();
	}

	// http://localhost:8686/product/delProduct
	@DeleteMapping("/delProductss/{pid}")
	public List<Product> delProduct(@PathVariable("pid") int pid) {
		return pservice.delProduct(pid);
	}

	// http://localhost:8686/product/editProduct
	@PostMapping("/editProducts/{pid}")
	public List<Product> editProduct(@PathVariable("pid") int pid, @RequestBody Product product) {
		return pservice.editProduct(pid, product);
	}

	// http://localhost:8686/product/toggleProduct - set status='A'
	@PostMapping("/toggleProducts/{pid}")
	public List<Product> toggleProduct(@PathVariable("pid") int pid) {
		return pservice.toggleProduct(pid);
	}

	// http://localhost:8686/product/toggleProduct - set status='N'
	@PostMapping("/toggleProductSeconds/{pid}")
	public List<Product> toggleProductSecond(@PathVariable("pid") int pid) {
		return pservice.toggleProductSecond(pid);
	}

	// categories

	// http://localhost:8686/product/Antibiotic
	@GetMapping("/Antibiotics")
	public List Antibiotic() {
		return pservice.Antibiotic();
	}

	// http://localhost:8686/product/INSULIN
	@GetMapping("/INSULINS")
	public List INSULIN() {
		return pservice.INSULIN();
	}

	// http://localhost:8686/product/SYRUP
	@GetMapping("/SYRUPS")
	public List SYRUP() {
		return pservice.SYRUP();
	}

	// testcases

	public List getProduct(int id) {
		return pservice.getProduct(id);
	}
}
