package com.zking.biz;

import java.util.List;

import com.zking.Entity.Student;

public interface StudentBiz {
	public void addStudent(Student student);
	
	public List<Student> query();
	
	public void delete(Student student);
	
	public void update(Student student);
}
