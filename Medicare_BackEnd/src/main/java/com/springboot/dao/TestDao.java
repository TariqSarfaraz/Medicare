package com.springboot.dao;

import java.util.List;

import com.springboot.model.Test;

public interface TestDao {

	List<Test> listAllTest();

	Test addTest(Test t);

	void deleteTest(int did);

	void updateTopic(Test t);

	Test findTest(int did);

	List<Test> login(Test t);

	List<Test> loginTwo(int id, String name);

}
