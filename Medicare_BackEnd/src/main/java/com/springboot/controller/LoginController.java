package com.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Login;
import com.springboot.service.LoginService;
import com.springboot.dto.LoginDto;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	// http://localhost:8686/login/addlogin
	@PostMapping("/addlogin") // registration
	public int addLogin(@RequestBody Login login) // Add new record
	{
		loginService.addNewUser(login);
		return login.getId();
	}

	// http://localhost:8686/login/getUser
	@GetMapping("/getUsers") // view customers
	public List<Login> getUser() {
		return loginService.getUser();
	}

	// http://localhost:8686/login/loginAdmin
	@PostMapping("/loginAdmin") // user login
	public Login adminLogin(@RequestBody LoginDto logindto) {
		Login login = loginService.loginAdmin(logindto.getId(), logindto.getPassword());

		return login;
	}

	// http://localhost:8686/login/getUserProfile/
	@GetMapping("/getUserProfile/{id}")
	public List<Login> getUserProfile(@PathVariable("id") int id) {
		return loginService.getUserProfile(id);
	}

	// http://localhost:8686/login/UpdateName/
	@PutMapping("/UpdateName/{Id}") // update profile
	public void UpdateName(@PathVariable("Id") int Id, @RequestBody Login login) {
		loginService.UpdateName(Id, login);
	}

}
