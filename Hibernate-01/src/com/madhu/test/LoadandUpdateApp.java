package com.madhu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.madhu.model.Student;
import com.madhu.util.HibernateUtil;
//add update in hibetnate.cfg.xml <property name="hibernate.hbm2ddl.auto">validate</property>
public class LoadandUpdateApp {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
	
		try {
		session = HibernateUtil.getSession();
		if(session!=null) {
			transaction=session.beginTransaction();
		}
		if(transaction!=null) {
			Student student = session.get(Student.class, 26);
			if(student!=null) {
			//student.setSid(269);
			student.setSname("kohli");
			//student.setSaddress("MI");
			student.setSage(30);
			
			session.update(student);
			flag=true;
			}else {
				System.out.println("record not existed..");
			}
			
		}
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("record updated successfully..");
			}else {
				transaction.rollback();
				System.out.println("record is not updated successfully..");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closesessionFactory();
		}
		
	}

}
