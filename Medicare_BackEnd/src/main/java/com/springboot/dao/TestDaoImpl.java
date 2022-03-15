package com.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.model.Test;

@Repository
public class TestDaoImpl implements TestDao {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	@Override
	public List<Test> listAllTest() {
		String sql = "Select t from Test t";
		Query qry = em.createQuery(sql);
		List<Test> TestList = qry.getResultList();
		System.out.println(TestList);
		return TestList;
	}

	@Transactional
	@Override
	public Test addTest(Test t) {
		em.persist(t);
		return t;
	}

	@Transactional
	@Override
	public void deleteTest(int did) {
		Test t = em.find(Test.class, did);
		em.remove(t);
	}

	@Transactional
	@Override
	public void updateTopic(Test t) {
		em.merge(t);
	}

	@Transactional
	@Override
	public Test findTest(int did) {
		Test findedRecords = em.find(Test.class, did);
		return findedRecords;
	}

	@Transactional
	@Override
	public List<Test> login(Test t) {
		int id = t.getId();
		System.out.println(id);
		String name = t.getName();
		System.out.println(name);
		Query qry = em.createQuery("select t from Test t where id:=id and name:=name");
		qry.setParameter("id", id);
		qry.setParameter("name", name);
		List t1 = qry.getResultList();
		return t1;
	}

	@Transactional
	@Override
	public List<Test> loginTwo(int id, String name) {
		Query qry = em.createQuery("select t from Test t where id:=id and name:=name");
		qry.setParameter("id", id);
		qry.setParameter("name", name);
		List t1 = qry.getResultList();
		return t1;

	}

}
