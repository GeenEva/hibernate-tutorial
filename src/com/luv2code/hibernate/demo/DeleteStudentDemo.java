package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()							
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		

		try {

			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 11);
			
			session.delete(myStudent);
			
			session.createQuery("Delete Student WHERE lastName='TikkieTikkie'")
				.executeUpdate();
			
			session.getTransaction().commit();
			
			
			
		}finally {
			factory.close();
		}


	}

}
