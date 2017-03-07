package com.teamericray.controllers;

import com.teamericray.models.Listing;
import com.teamericray.models.repositories.UserRepository;
import com.teamericray.models.repositories.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("user/{userId}/listings")
public class ListingRestController {

	private final ListingRepository listingRepository;
	private final UserRepository userRepository;

	@Autowired
	ListingRestController(ListingRepository listingRepository,
	                      UserRepository userRepository) {
		this.listingRepository = listingRepository;
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	Collection<Listing> getListings(@PathVariable String userId) {
//		return this.listingRepository.findByUserId(Long.valueOf(userId));
		return this.userRepository.findById(Long.valueOf(userId)).get().getListings();
	}
}
