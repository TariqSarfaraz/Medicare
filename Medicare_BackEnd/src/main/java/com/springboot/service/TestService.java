package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.springboot.dao.TestDao;
import com.springboot.model.Test;

public interface TestService {

	public List<Test> listAllTest();

	public Test addTest(Test t);

	public void updateTopic(Test t);

	public void deleteTest(int did);

	public Test findTest(int did);

	public List<Test> loginTwo(int id, String name);

}
