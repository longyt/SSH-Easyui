package com.zking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zking.Entity.Student;

public class StudentDaoImpl implements StudentDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void add(Student student) {
		getSession().save(student);
	}
	
	@Override
	public List<Student> query() {
		// TODO Auto-generated method stub
		List<Student> list = getSession().createQuery("from Student").list();
		return list;
	}
	
	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		getSession().delete(student);
	}
	
	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		getSession().update(student);
	}

}
