package springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	public TrackCoach() {
	}

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "run 5k";
	}

	@Override
	public String getDailyForture() {
		return "Just do it: " + fortuneService.getForture();
	}
	
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: start up");
	}
	
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: clean up");
	}
}
