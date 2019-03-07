package hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save Java object
			
			System.out.println("Creating new Student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@google.com");
			
			session.beginTransaction();
			System.out.println("Saving the Student object...");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
