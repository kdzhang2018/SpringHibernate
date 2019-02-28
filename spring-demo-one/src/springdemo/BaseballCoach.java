package springdemo;

public class BaseballCoach implements Coach {
	// dependency
	private FortuneService fortureService;
	
	public BaseballCoach(FortuneService theFortureService) {
		fortureService = theFortureService;
	}
	@Override
	public String getDailyWorkout() {
		return "spend 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortureService.getFortune();
	}
}
