package hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save Java object
			
			System.out.println("Creating new Student object...");
			Student tempStudent = new Student("Daffe", "Duck", "daffe@google.com");
			
			session.beginTransaction();
			System.out.println("Saving the Student object...");
			System.out.println(tempStudent);
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Saved student. Generate id: "+ tempStudent.getId());
			
			// read object based on id
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting Student with id: "+ tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: " + tempStudent);
			
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
