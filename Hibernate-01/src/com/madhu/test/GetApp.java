package com.madhu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.madhu.model.Student;
import com.madhu.util.HibernateUtil;
//add validate in hibetnate.cfg.xml <property name="hibernate.hbm2ddl.auto">validate</property>
public class GetApp {

	public static void main(String[] args) {
		Session session=null;
		int id= 26;
		try {
		session = HibernateUtil.getSession();
		if(session!=null) {
			Student student = session.get(Student.class, id);
			System.out.println("student:"+student);
			if(student!=null) {
				System.out.println("student id::"+student.getSid());
				System.in.read();
				System.out.println("student name::"+student.getSname());
				System.out.println("student age::"+student.getSage());
				System.out.println("student address::"+student.getSaddress());
			}
		}
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closesessionFactory();
		}
		
	}

}
