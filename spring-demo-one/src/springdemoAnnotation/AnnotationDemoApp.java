package springdemoAnnotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-Annotation.xml");
		
		//Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		
		// Default component names
		TennisCoach theCoach = context.getBean("tennisCoach", TennisCoach.class);
		//TennisCoach alphaCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		//System.out.println("Pointing to the same object: " + (theCoach == alphaCoach));
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getTeam());
		System.out.println(theCoach.getEmailAddress());
		
		context.close();

	}

}
