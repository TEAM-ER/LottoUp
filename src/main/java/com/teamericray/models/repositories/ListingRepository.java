package com.teamericray.models.repositories;

import com.teamericray.models.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ListingRepository extends JpaRepository<Listing, Long> {
	Collection<Listing> findByAccountUsername(String username);
}
