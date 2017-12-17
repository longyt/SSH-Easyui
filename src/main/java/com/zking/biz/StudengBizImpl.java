package com.zking.biz;

import java.util.List;

import com.zking.Entity.Student;
import com.zking.dao.StudentDao;
import com.zking.dao.StudentDaoImpl;

public class StudengBizImpl implements StudentBiz{

	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.add(student);
	}
	
	@Override
	public List<Student> query() {
		// TODO Auto-generated method stub
		return studentDao.query();
	}
	
	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentDao.delete(student);
	}
	
	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}
	
}
