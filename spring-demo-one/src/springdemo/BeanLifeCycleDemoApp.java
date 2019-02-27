package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load spring configuration
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve bean
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods
		System.out.println(theCoach.getDailyWorkout());
		
		// close
		context.close();
	}

}
