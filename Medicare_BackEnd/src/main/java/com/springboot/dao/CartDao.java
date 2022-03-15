package com.springboot.dao;

import java.util.List;

import com.springboot.model.Cart;
import com.springboot.model.Product;

public interface CartDao {

	List listAllPrdinCart();

	List cartlistbyloginsid(int id);

	int addToCart(Cart cart);

	List sumofproduct(int id);

	List updateaddone(int pid, int lid, int prd_qty);

	List updateaddonebutton(int pid, int lid);

	List updatesubonebutton(int pid, int lid);

	List bookedProducts(int id);

	List makebooking(int id);

	List sumOfPrdAndQty(int lid);

	List delProductfromCart(int pid);

	List forprint(int id);

	List fornotprint(int id);

	List search(String name);

	List Antibiotic();

}
