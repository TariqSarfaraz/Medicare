package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.LoginDao;
import com.springboot.model.Login;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao dao;

	public LoginDao getDao() {
		return dao;
	}

	public void setDao(LoginDao dao) {
		this.dao = dao;
	}

	@Override
	public int addNewUser(Login login) {
		// TODO Auto-generated method stub
		return dao.addNewUser(login);
	}

	@Override
	public List<Login> getUser() {
		// TODO Auto-generated method stub
		return dao.getUser();
	}

	@Override
	public Login loginAdmin(int id, String password) {

		return dao.loginAdmin(id, password);
	}

	@Override
	public List<Login> getUserProfile(int id) {
		// TODO Auto-generated method stub
		return dao.getUserProfile(id);
	}

	@Override
	public List UpdateName(String name, int id) {
		// TODO Auto-generated method stub
		return dao.UpdateName(name, id);
	}

	@Override
	public void UpdateName(int Id, Login login) {
		// TODO Auto-generated method stub
		dao.UpdateName(Id, login);
	}

}
