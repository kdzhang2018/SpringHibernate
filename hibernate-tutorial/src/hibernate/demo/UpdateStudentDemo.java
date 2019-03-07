package hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save Java object
			
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, 1);
			System.out.println(myStudent);
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");
			
			System.out.println(myStudent);
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
