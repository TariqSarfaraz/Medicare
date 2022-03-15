package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Cart;
import com.springboot.model.Product;
import com.springboot.service.CartService;
import com.springboot.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService cservice;

	// http://localhost:8686/carts/cartlists
	@GetMapping("/cartlists")
	public List listAllPrdinCart() {
		return cservice.listAllPrdinCart();
	}

	// http://localhost:8686/carts/cartlistsbyloginsid
	@GetMapping("/cartlistsbyloginsid/{id}")
	public List cartlistbyloginsid(@PathVariable("id") int id) {
		return cservice.cartlistbyloginsid(id);
	}

	// http://localhost:8686/carts/addToCarts
	@PostMapping("/addToCarts")
	public int addToCart(@RequestBody Cart cart) {
		return cservice.addToCart(cart);
	}

	// http://localhost:8686/carts/sumofproducts
	@GetMapping("/sumofproducts/{id}")
	public List sumofproduct(@PathVariable("id") int id) {
		return cservice.sumofproduct(id);
	}

	// http://localhost:8686/carts/bookedProducts/
	@GetMapping("/bookedProducts/{id}")
	public List<Cart> bookedProducts(@PathVariable("id") int id) {
		return cservice.bookedProducts(id);
	}

	// http://localhost:8686/carts/makebooking/
	@PutMapping("/makebooking/{id}")
	public List makebooking(@PathVariable("id") int id) {
		return cservice.makebooking(id);
	}

	// http://localhost:8686/carts/sumOfPrdAndQty/{lid}
	@PostMapping("/sumOfPrdAndQty/{lid}")
	public List sumOfPrdAndQty(int lid) {
		return cservice.sumOfPrdAndQty(lid);
	}

	// http://localhost:8686/carts/delProductfromCarts/{lid}/{pid}
	@DeleteMapping("/delProductfromCarts/{pid}")
	public List delProductfromCart(@PathVariable("pid") int pid) {
		return cservice.delProductfromCart(pid);
	}

	// http://localhost:8686/carts/search/
	@PutMapping("/search/{name}") // search
	public List search(@PathVariable("name") String name) {
		return cservice.search(name);
	}

}
