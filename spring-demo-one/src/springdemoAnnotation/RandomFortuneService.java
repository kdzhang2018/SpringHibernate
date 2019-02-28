package springdemoAnnotation;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	private String[] data = {"lucky", "luckier", "luckiest"};
	private Random rand = new Random();
	
	@Override
	public String getFortune() {
		return data[rand.nextInt(data.length)];
	}

}
