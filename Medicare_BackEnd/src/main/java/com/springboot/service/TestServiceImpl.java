package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.TestDao;
import com.springboot.model.Test;

@Service("testservice")
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao tdao;

	@Override
	public List<Test> listAllTest() {
		// TODO Auto-generated method stub
		return tdao.listAllTest();
	}

	@Override
	public Test addTest(Test t) {
		// TODO Auto-generated method stub
		return tdao.addTest(t);
	}

	@Override
	public void deleteTest(int did) {
		// TODO Auto-generated method stub
		tdao.deleteTest(did);
	}

	@Override
	public void updateTopic(Test t) {
		// TODO Auto-generated method stub
		tdao.updateTopic(t);

	}

	@Override
	public Test findTest(int did) {
		// TODO Auto-generated method stub
		return tdao.findTest(did);
	}

	@Override
	public List<Test> loginTwo(int id, String name) {
		// TODO Auto-generated method stub
		return tdao.loginTwo(id, name);
	}

}
