package com.madhu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.madhu.model.Student;
import com.madhu.util.HibernateUtil;

public class SaveApp {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction=null;
		boolean flag= false;
		try {
			session = HibernateUtil.getSession();
			System.out.println("session:"+session);
			if (session != null) {
                  transaction = session.beginTransaction();
                  System.out.println("transaction:"+transaction);
			}
			if(transaction!=null) {
				Student student = new Student();
				student.setSid(22);
				student.setSname("kohli");
				student.setSaddress("Rcb");
				student.setSage(35);
				
				Integer id= (Integer)session.save(student);
				System.out.println("id:"+id);
				flag=true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				System.out.println("object saved to database");
			}else {
				transaction.rollback();
				System.out.println("object is not saved to database");
			}
		}
		HibernateUtil.closeSession(session);
		HibernateUtil.closesessionFactory();

	}

}
