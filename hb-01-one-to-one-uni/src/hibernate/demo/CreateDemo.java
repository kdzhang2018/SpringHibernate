package hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// use session object to save Java object
			//Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@google.com");
			//InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "code");
			
			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@google.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.gmail.com", "Guitar");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.beginTransaction();
			
			// CascadeType.ALL

			System.out.println("Saving the Instructor object..." + tempInstructor);
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}finally {
			factory.close();
		}
	}

}
