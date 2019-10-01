package com.luv2code.hibernate.demo;

import java.util.Date;

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

			String dateOfBirth = "11/11/1981";
			Date theDateOfBirth = DateUtils.parseDate(dateOfBirth);
			
			Student theStudent = new Student("Evolino", "TikkieTikkie", "mijn@email", theDateOfBirth );

			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			factory.close();
		}


	}

}
