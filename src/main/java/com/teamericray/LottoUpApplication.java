package com.teamericray;

import com.teamericray.models.Account;
import com.teamericray.models.Listing;
import com.teamericray.models.repositories.AccountRepository;
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
	CommandLineRunner init(AccountRepository accountRepository,
	                       ListingRepository listingRepository) {
		return (args) -> Arrays.asList("Eric,Raymond".split(",")).forEach(
				username -> {
					Account account = accountRepository.save(new Account(username));
					listingRepository.save(new Listing(account, 50.00, 0));
					listingRepository.save(new Listing(account, 60.00, 0));
				});
	}
}
