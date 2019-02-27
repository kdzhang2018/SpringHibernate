package springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getForture() {
		return "lucky day";
	}

}
