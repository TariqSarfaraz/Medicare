package com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.model.Login;
import com.springboot.model.Product;
import com.springboot.model.Test;

@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public List<Product> listAllPrd() {
		String sql = "Select t from Product t ";
		Query qry = em.createQuery(sql);
		List<Product> ProductList = qry.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List<Product> ListAvaPrd() {
		String sql = "Select t from Product t where t.status='A' ";
		Query qry = em.createQuery(sql);
		List<Product> ProductList = qry.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public int addProduct(Product product) {
		em.merge(product);
		return product.getPid();
	}

	@Transactional
	@Override
	public List<Product> delProduct(int pid) {
		Product t = em.find(Product.class, pid);
		em.remove(t);
		String sql = "Select t from Product t ";
		Query qry = em.createQuery(sql);
		List<Product> ProductList = qry.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List<Product> editProduct(int pid, Product product) {
		Product t = em.find(Product.class, pid);
		if (t != null)
			em.merge(product);

		String sql = "Select t from Product t";
		Query qry = em.createQuery(sql);
		List<Product> ProductList = qry.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List<Product> toggleProduct(int pid) {
		Query query = em.createQuery("Update Product t set t.status='A' where pid=:pid ");
		query.setParameter("pid", pid);
		query.executeUpdate();

		String sql1 = "Select t from Product t";
		Query qry1 = em.createQuery(sql1);
		List<Product> ProductList = qry1.getResultList();
		return ProductList;

	}

	@Transactional
	@Override
	public List<Product> toggleProductSecond(int pid) {
		Query query = em.createQuery("Update Product t set t.status='N' where pid=:pid ");
		query.setParameter("pid", pid);
		query.executeUpdate();

		String sql1 = "Select t from Product t";
		Query qry1 = em.createQuery(sql1);
		List<Product> ProductList = qry1.getResultList();
		return ProductList;

	}

	// categories

	@Transactional
	@Override
	public List Antibiotic() {
		Query qry = em.createQuery("select c from Product c where ptype='Antibiotic'");
		List ProductList = qry.getResultList();
		return ProductList;
	}

	@Transactional
	@Override
	public List INSULIN() {
		Query qry = em.createQuery("select c from Product c where ptype='Insulin'");
		List ProductList = qry.getResultList();
		return ProductList;
	}

	@Transactional
	@Override
	public List SYRUP() {
		Query qry = em.createQuery("select c from Product c where ptype='Syrup'");
		List ProductList = qry.getResultList();
		return ProductList;
	}

	@Override
	public List getProduct(int id) {
		Product p = em.find(Product.class, id);

		Query qry = em.createQuery("select p from Products where pid=:id");

		return null;
	}

}
