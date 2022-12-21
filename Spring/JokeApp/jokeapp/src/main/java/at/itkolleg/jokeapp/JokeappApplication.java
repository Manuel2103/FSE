package at.itkolleg.jokeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JokeappApplication implements ApplicationRunner {

	@Autowired
	JokesRepository myJokesRepository;


	public static void main(String[] args) {
		SpringApplication.run(JokeappApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		myJokesRepository.save(new Joke(null, "Chuck Norris pausiert Online spiele", "Chuck-Norris-Witze", 0 ));
		myJokesRepository.save(new Joke(null, "Chuck Norris trinkt aus dem Wasserhahn ex", "Chuck-Norris-Witze", 10 ));
		myJokesRepository.save(new Joke(null, "Wie heißt ein helles Mammut, Helmut", "Flachwitze", 0 ));

		System.out.println("Hallo Application Runner!");
	}
}
