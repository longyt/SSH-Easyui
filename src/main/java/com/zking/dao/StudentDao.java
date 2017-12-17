package com.zking.dao;

import java.util.List;

import com.zking.Entity.Student;

public interface StudentDao {
	public void add(Student student);
	
	public List<Student> query(); 
	
	public void delete(Student student);
	
	public void update(Student student);
	
}
