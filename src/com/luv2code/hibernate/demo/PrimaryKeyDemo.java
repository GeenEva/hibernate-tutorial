package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()						
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Student theStudent = new Student("Lieke", "van Landeren", "haar@email");
			Student theStudent2 = new Student("Hans", "de Boer", "zijn@email");
			Student theStudent3 = new Student("Jansje", "Klasse", "hullie@eimaw");
			
			session.beginTransaction();
			
			session.save(theStudent);
			session.save(theStudent2);
			session.save(theStudent3);
			
			session.getTransaction().commit();
			

		}finally {
			factory.close();
		}


	}

}
