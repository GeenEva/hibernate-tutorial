package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()							//default is "hibernate.cfg.xml"
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student theStudent = new Student("Eva", "van Geenen", "mijn@email");

			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			

		}finally {
			factory.close();
		}


	}

}
