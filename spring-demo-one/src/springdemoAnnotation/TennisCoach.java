package springdemoAnnotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
//default singleton
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	// field injection
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String emailAddress;
	
	@Value("${foo.team}")
	private String team;
	
	public TennisCoach() {
		System.out.println("TennisCoach: default constructor");
	}
	
	// constructor injection	
	/*@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/
	
	// setter injection
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("TennisCoach: setFortuneService");
		this.fortuneService = fortuneService;
	}*/

	// method injection
	/*@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("TennisCoach: doSomeCrazyStuff");
		this.fortuneService = fortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "practice";
	}
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	@PreDestroy
	public void doSomeCleanupStuff() {
		System.out.println("TennisCoach: doSomeCleanupStuff");
	}
	
	@PostConstruct
	public void doSomeStartupStuff() {
		System.out.println("TennisCoach: doSomeStartupStuff");
	}
}
