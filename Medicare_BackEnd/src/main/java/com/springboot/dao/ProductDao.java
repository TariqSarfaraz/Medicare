package com.springboot.dao;

import java.util.List;

import com.springboot.model.Product;
import com.springboot.model.Test;

public interface ProductDao {

	List<Product> listAllPrd();

	int addProduct(Product product);

	List<Product> ListAvaPrd();

	List<Product> delProduct(int pid);

	List<Product> editProduct(int pid, Product product);

	List<Product> toggleProduct(int pid);

	List<Product> toggleProductSecond(int pid);

	List Antibiotic();

	List INSULIN();

	List SYRUP();

	List getProduct(int id);

}
