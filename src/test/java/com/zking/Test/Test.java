package com.zking.Test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zking.Entity.Student;
import com.zking.biz.StudentBiz;

public class Test {
	
	@org.junit.Test
	public void Test(){
		/*Configuration configuration=new Configuration().configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction= session.beginTransaction();
		
		session.save(new Student(120, "ÄÐ", "¼ª¼ª"));
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();*/
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"applicationContext_public.xml","applicationContext_dao.xml","applicationContext_biz.xml"});
		StudentBiz studentBiz = (StudentBiz) context.getBean("studengBiz");
		//studentBiz.addStudent(new Student(19,"ÄÐ","kkk"));
		List<Student> list = studentBiz.query();
		System.out.println(list.size());
	}

}
