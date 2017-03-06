package com.teamericray.controllers;

import com.teamericray.models.Listing;
import com.teamericray.models.repositories.AccountRepository;
import com.teamericray.models.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/{userId}/listings")
public class ListingRestController {

	private final ListingRepository listingRepository;
	private final AccountRepository accountRepository;

	@Autowired
	ListingRestController(ListingRepository listingRepository,
	                      AccountRepository accountRepository) {
		this.listingRepository = listingRepository;
		this.accountRepository = accountRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<Listing> getListings(@PathVariable String userId) {
		return this.listingRepository.findByAccountUsername(userId);
	}
}
