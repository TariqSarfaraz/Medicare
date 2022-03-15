package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.CartDao;
import com.springboot.dao.ProductDao;
import com.springboot.model.Cart;
import com.springboot.model.Product;

@Service("cservice")
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao dao;

	public CartDao getDao() {
		return dao;
	}

	public void setDao(CartDao dao) {
		this.dao = dao;
	}

	@Override
	public List listAllPrdinCart() {
		// TODO Auto-generated method stub
		return dao.listAllPrdinCart();
	}

	@Override
	public List cartlistbyloginsid(int id) {
		// TODO Auto-generated method stub
		return dao.cartlistbyloginsid(id);
	}

	@Override
	public int addToCart(Cart cart) {
		// TODO Auto-generated method stub
		return dao.addToCart(cart);
	}

	@Override
	public List sumofproduct(int id) {
		// TODO Auto-generated method stub
		return dao.sumofproduct(id);
	}

	@Override
	public List updateaddone(int pid, int lid, int prd_qty) {
		// TODO Auto-generated method stub
		return dao.updateaddone(pid, lid, prd_qty);
	}

	@Override
	public List updateaddone(int pid, int lid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List updateaddonebutton(int pid, int lid) {
		// TODO Auto-generated method stub
		return dao.updateaddonebutton(pid, lid);
	}

	@Override
	public List updatesubonebutton(int pid, int lid) {
		// TODO Auto-generated method stub
		return dao.updatesubonebutton(pid, lid);
	}

	@Override
	public List bookedProducts(int id) {
		// TODO Auto-generated method stub
		return dao.bookedProducts(id);
	}

	@Override
	public List makebooking(int id) {
		// TODO Auto-generated method stub
		return dao.makebooking(id);
	}

	@Override
	public List sumOfPrdAndQty(int lid) {
		// TODO Auto-generated method stub
		return dao.sumOfPrdAndQty(lid);
	}

	@Override
	public List delProductfromCart(int pid) {
		// TODO Auto-generated method stub
		return dao.delProductfromCart(pid);
	}

	@Override
	public List forprint(int id) {
		// TODO Auto-generated method stub
		return dao.forprint(id);
	}

	@Override
	public List fornotprint(int id) {
		// TODO Auto-generated method stub
		return dao.fornotprint(id);
	}

	@Override
	public List search(String name) {
		// TODO Auto-generated method stub
		return dao.search(name);
	}

	@Override
	public List Antibiotic() {
		// TODO Auto-generated method stub
		return dao.Antibiotic();
	}

}
