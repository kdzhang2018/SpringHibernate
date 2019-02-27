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

}
