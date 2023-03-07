package com.madhu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.madhu.model.Student;
import com.madhu.util.HibernateUtil;
//add validate in hibetnate.cfg.xml <property name="hibernate.hbm2ddl.auto">validate</property>
public class LoadandDelete {

	public static void main(String[] args) {
		Session session =null;
		Transaction transaction=null;
		boolean flag=true;
		try {
			session= HibernateUtil.getSession();
			Student student = session.get(Student.class, 28);
			if(session!=null) {
				transaction = session.beginTransaction();
				
			}
			if(transaction!=null) {
				if(student!=null) {
				
				
				session.delete(student);
				flag=true;
				}
			}
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("record deletde");
			}else {
				transaction.rollback();
				System.out.println("record  not deletde");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closesessionFactory();
		}
		
	}

}
