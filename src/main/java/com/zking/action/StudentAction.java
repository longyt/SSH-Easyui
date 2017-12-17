package com.zking.action;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.zking.Entity.Student;
import com.zking.biz.StudentBiz;

public class StudentAction extends ActionSupport{
	
	private Student student;
	
	private StudentBiz studentBiz;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentBiz getStudentBiz() {
		return studentBiz;
	}

	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}
	
	
	public String add() throws Exception {
		Student student = (Student) InsertSstuEntity(Student.class);
		studentBiz.addStudent(student);
		return this.SUCCESS;
	}
	
	public void query() throws IOException{
		List<Student> list = studentBiz.query();
		String jsonlist = JSON.toJSONString(list);
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(jsonlist);
	}
	
	public String delete() throws Exception{
		Student student = (Student) InsertSstuEntity(Student.class);
		studentBiz.delete(student);
		return this.SUCCESS;
	}
	
	
	public String update() throws Exception{
		Student student = (Student) InsertSstuEntity(Student.class);
		studentBiz.update(student);
		return this.SUCCESS;
	}
	
	
	public Object InsertSstuEntity(Class clazz) throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		Enumeration<String> ParameterNames=request.getParameterNames();
		Field [] fields = clazz.getDeclaredFields();
		Object object = clazz.newInstance();
		while(ParameterNames.hasMoreElements()){
			String Parametername = ParameterNames.nextElement();
			String[] Parametervalue = request.getParameterValues(Parametername);
			//
			for (Field field : fields){
				field.setAccessible(true);
				Object tempvalue = null;
				if(field.getName().equals(Parametername)){
					if(field.getType().getSimpleName().equals("Integer")){
						tempvalue = Integer.parseInt(Parametervalue[0]);
						field.set(object, tempvalue);
						break;
					}else{
						tempvalue = Parametervalue[0];
						field.set(object, tempvalue);
						break;
					}
				}
		}
	}
		return object;
}

	
}
