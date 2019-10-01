package com.luv2code.hibernate.demo;

import java.text.ParseException;

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

			Student theStudent = new Student("Lieke", "van Landeren", "haar@email", DateUtils.useDefaultDate());
			Student theStudent2 = new Student("Hans", "de Boer", "zijn@email", DateUtils.useDefaultDate());
			Student theStudent3 = new Student("Jansje", "Klasse", "hullie@eimaw", DateUtils.useDefaultDate());
			
			session.beginTransaction();
			
			session.save(theStudent);
			session.save(theStudent2);
			session.save(theStudent3);
			
			session.getTransaction().commit();
			

		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}


	}

}
