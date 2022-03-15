package com.springboot.service;

import java.util.List;

import com.springboot.model.Login;

public interface LoginService {

	public abstract int addNewUser(Login login);

	public abstract List<Login> getUser();

	public abstract Login loginAdmin(int id, String password);

	public abstract List<Login> getUserProfile(int id);

	List UpdateName(String name, int id);

	public abstract void UpdateName(int Id, Login login);

}
