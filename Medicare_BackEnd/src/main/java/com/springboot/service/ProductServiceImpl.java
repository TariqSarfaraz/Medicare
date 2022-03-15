package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.LoginDao;
import com.springboot.dao.ProductDao;
import com.springboot.model.Product;
import com.springboot.model.Test;

@Service("pservice")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	public ProductDao getDao() {
		return dao;
	}

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Product> listAllPrd() {
		// TODO Auto-generated method stub
		return dao.listAllPrd();
	}

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.addProduct(product);

	}

	@Override
	public List<Product> ListAvaPrd() {
		// TODO Auto-generated method stub
		return dao.ListAvaPrd();
	}

	@Override
	public List<Product> delProduct(int pid) {
		// TODO Auto-generated method stub
		return dao.delProduct(pid);
	}

	@Override
	public List<Product> editProduct(int pid, Product product) {
		// TODO Auto-generated method stub
		return dao.editProduct(pid, product);
	}

	@Override
	public List<Product> toggleProduct(int pid) {
		// TODO Auto-generated method stub
		return dao.toggleProduct(pid);
	}

	@Override
	public List<Product> toggleProductSecond(int pid) {
		// TODO Auto-generated method stub
		return dao.toggleProductSecond(pid);
	}

	@Override
	public List Antibiotic() {
		// TODO Auto-generated method stub
		return dao.Antibiotic();
	}

	@Override
	public List INSULIN() {
		// TODO Auto-generated method stub
		return dao.INSULIN();
	}

	@Override
	public List SYRUP() {
		// TODO Auto-generated method stub
		return dao.SYRUP();
	}

	@Override
	public List getProduct(int id) {
		// TODO Auto-generated method stub
		return dao.getProduct(id);
	}

}
