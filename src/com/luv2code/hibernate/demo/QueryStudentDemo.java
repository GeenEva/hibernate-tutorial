package com.luv2code.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()							//default is "hibernate.cfg.xml"
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			displayStudents(studentList);
			
			studentList = session.createQuery("from Student s where s.lastName='Klasse'").getResultList();
			
			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.lastName='Klasse' OR s.firstName='Hans'").getResultList();
			
			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.email LIKE '%@froofroo.com'").getResultList();
			
			displayStudents(studentList);
			
			session.getTransaction().commit();
			

		}finally {
			factory.close();
		}


	}

	private static void displayStudents(List<Student> studentList) {
		for(Student s: studentList) {
			System.out.println(s);
		}
	}

}
