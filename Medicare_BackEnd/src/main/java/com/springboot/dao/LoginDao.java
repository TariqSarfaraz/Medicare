package com.springboot.dao;

import java.util.List;

import com.springboot.model.Login;

public interface LoginDao {

	List<Login> getUser();

	int addNewUser(Login login);

	public Login loginAdmin(int id, String password);

	List<Login> getUserProfile(int id);

	List UpdateName(String name, int id);

	void UpdateName(int Id, Login login);

}
