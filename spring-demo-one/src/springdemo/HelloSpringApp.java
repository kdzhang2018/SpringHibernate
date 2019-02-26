package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// spring configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods
		System.out.println(theCoach.getDailyWorkout());
		
		// close
		context.close();

	}

}
