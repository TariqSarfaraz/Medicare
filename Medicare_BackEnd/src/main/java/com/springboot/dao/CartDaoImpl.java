package com.springboot.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.model.Cart;
import com.springboot.model.Login;
import com.springboot.model.Product;

@Repository
public class CartDaoImpl implements CartDao {

	@PersistenceContext
	private EntityManager em;

	// list of all products
	@Transactional
	@Override
	public List listAllPrdinCart() {
		String sql = "Select t from Cart t ";
		Query qry = em.createQuery(sql);
		List ProductList = qry.getResultList();
		return ProductList;

	}

	// cart list using logins id
	@Transactional
	@Override
	public List cartlistbyloginsid(int id) {
		Query qry = em.createQuery("Select p from Cart p where p.lid=:id and booked='U'");
		qry.setParameter("id", id);
		List ProductList = qry.getResultList();
		System.out.println(ProductList);
		return ProductList;
	}

	// adding to cart
	@Transactional
	@Override
	public int addToCart(Cart cart) {
		em.persist(cart);
		return cart.getId();
	}

	// sum of product
	@Transactional
	@Override
	public List sumofproduct(int id) {
		Query qry = em.createQuery("Select sum(price) from Cart c where c.lid=:id and booked='U'");
		qry.setParameter("id", id);
		List Sum = qry.getResultList();
		System.out.println(qry.getResultList());
		return Sum;

	}

	// getting list of booked products
	@Transactional
	@Override
	public List bookedProducts(int id) {
		Query qry = em.createQuery("select c from Cart c where c.lid=:id and c.booked='B'");
		qry.setParameter("id", id);
		List Sum = qry.getResultList();
		System.out.println(Sum);
		return Sum;

	}

	// updating products as booked
	@Modifying
	@Transactional
	@Override
	public List makebooking(int id) {
		Query qry = em.createQuery("Update Cart c set c.booked='B' where lid=:id");
		qry.setParameter("id", id);
		qry.executeUpdate();
		String sql = "Select t from Cart t ";
		Query qry1 = em.createQuery(sql);
		List ProductList = qry1.getResultList();
		return ProductList;

	}

	@Modifying
	@Transactional
	@Override
	public List sumOfPrdAndQty(int lid) {
		Query qry = em.createQuery(
				"select p.price*c.prd_qty from Product p inner join Cart c on p.pid = c.pid where c.lid =:lid and c.prd_qty>0");
		qry.setParameter("lid", lid);
		qry.executeUpdate();
		String sql = "Select t from Cart t ";
		Query qry1 = em.createQuery(sql);
		List ProductList = qry1.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List delProductfromCart(int id) {
		Cart t = em.find(Cart.class, id);
		em.remove(t);
		String sql = "Select t from Cart t ";
		Query qry = em.createQuery(sql);
		List ProductList = qry.getResultList();
		return ProductList;

	}

	// updating products as booked
	@Modifying
	@Transactional
	@Override
	public List forprint(int id) {
		Query qry = em.createQuery("Update Cart c set c.print='P' where lid=:id");
		qry.setParameter("id", id);
		qry.executeUpdate();
		String sql = "Select t from Cart t where print='P'";
		Query qry1 = em.createQuery(sql);
		List ProductList = qry1.getResultList();
		return ProductList;

	}

	// updating products as booked
	@Modifying
	@Transactional
	@Override
	public List fornotprint(int id) {
		Query qry = em.createQuery("Update Cart c set c.print='N' where lid=:id");
		qry.setParameter("id", id);
		qry.executeUpdate();
		String sql = "Select t from Cart t where print='N'";
		Query qry1 = em.createQuery(sql);
		List ProductList = qry1.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List search(String name) {
		Query qry = em.createQuery("select c from Product c where c.pname=:name");
		qry.setParameter("name", name);
		List ProductList = qry.getResultList();
		return ProductList;
	}

	// Categories

	@Transactional
	@Override
	public List Antibiotic() {
		Query qry = em.createQuery("select c from Product c where c.pname='Antibiotic'");
		List ProductList = qry.getResultList();
		return ProductList;
	}

	@Transactional
	@Override
	public List updateaddone(int pid, int lid, int prd_qty) {

		Query qry = em.createQuery("Update Cart c set c.prd_qty=:prd_qty where pid=:pid and lid =:lid");
		qry.setParameter("prd_qty", prd_qty);
		qry.setParameter("pid", pid);
		qry.setParameter("lid", lid);
		qry.executeUpdate();
		String sql = "Select t from Cart t ";
		Query qry1 = em.createQuery(sql);
		List ProductList = qry1.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List updateaddonebutton(int pid, int lid) {

		Query qry = em.createQuery("Update Cart c set prd_qty=prd_qty+1 where pid=:pid and lid =:lid");

		qry.setParameter("pid", pid);
		qry.setParameter("lid", lid);
		qry.executeUpdate();
		String sql = "Select t from Cart t ";
		Query qry1 = em.createQuery(sql);
		List ProductList = qry1.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List updatesubonebutton(int pid, int lid) {

		Query qry = em.createQuery("Update Cart c set prd_qty=prd_qty-1 where pid=:pid and lid =:lid");
		qry.setParameter("pid", pid);
		qry.setParameter("lid", lid);
		qry.executeUpdate();
		String sql = "Select t from Cart t ";
		Query qry1 = em.createQuery(sql);
		List ProductList = qry1.getResultList();
		return ProductList;

	}

}
