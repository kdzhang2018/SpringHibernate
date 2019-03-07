package hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			
			theStudents = session.createQuery("from Student s where" 
					+ " s.lastName='Doe' OR s.firstName='Daffe'").getResultList();
			System.out.println("\nStudents with last name Doe or first name Daffe");
			displayStudents(theStudents);
			
			
			theStudents = session.createQuery("from Student s where" 
					+ " s.email LIKE '%google.com'").getResultList();
			System.out.println("\nStudents with email ending with google.com");
			displayStudents(theStudents);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
