package springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}
	public void setTeam(String team) {
		System.out.println("CricketCoach: setter method - setTeam");
		this.team = team;
	}
	public CricketCoach() {
		System.out.println("CricketCoach: no-arg constructor");
	}
	@Override
	public String getDailyWorkout() {
		return "practice fast bowling";
	}

	@Override
	public String getDailyForture() {
		return fortuneService.getForture();
	}

}
