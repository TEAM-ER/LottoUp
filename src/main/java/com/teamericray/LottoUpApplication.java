package com.teamericray;

import com.teamericray.models.User;
import com.teamericray.models.Listing;
import com.teamericray.models.repositories.UserRepository;
import com.teamericray.models.repositories.ListingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class LottoUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LottoUpApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
	                       ListingRepository listingRepository) {
		return (args) -> Arrays.asList("Eric,Raymond".split(",")).forEach(
				username -> {
					if (username.equals("Eric")) {
						User user = userRepository.save(new User(username));
						listingRepository.save(new Listing(user, "Macbook Pro",40.00, 5));
						listingRepository.save(new Listing(user, "Macbook Pro",50.00, 5));
						listingRepository.save(new Listing(user, "Macbook Pro", 60.00, 5));
					} else {
						User user = userRepository.save(new User(username));
						listingRepository.save(new Listing(user, "Macbook",50.00, 0));
						listingRepository.save(new Listing(user, "Macbook",60.00, 0));
					}
				});
	}
}
