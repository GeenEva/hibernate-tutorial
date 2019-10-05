package com.luv2code.hibernate.demo;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()							
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		

		try {

			int studentId = 6;
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studentId);
			
			myStudent.setLastName("TikkieTikkie");
			
			session.getTransaction().commit();
			
			
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			session.createQuery("UPDATE Student set email='lalal@la.com' WHERE lastName='TikkieTikkie'")
				.executeUpdate();
			
			session.getTransaction().commit();
			
			
			
		}finally {
			factory.close();
		}


	}

}
