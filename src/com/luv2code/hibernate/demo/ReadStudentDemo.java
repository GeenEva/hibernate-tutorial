package com.luv2code.hibernate.demo;

import java.io.Serializable;
import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()							
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		

		try {

			Student miaStudent = new Student("Tiffany", "Hooks", "tiffy@froofroo.com", DateUtils.useDefaultDate());
			
			session.beginTransaction();
			
			session.save(miaStudent);
				
			System.out.println("Saved student id: " + miaStudent.getId());
			
			System.out.println("Get student with id=5: " + session.get(Student.class, 5));
			
			session.getTransaction().commit();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			factory.close();
		}


	}

}
