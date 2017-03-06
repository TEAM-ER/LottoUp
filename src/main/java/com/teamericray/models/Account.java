package com.teamericray.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "account")
	private Set<Listing> listings = new HashSet<>();

	@JsonIgnore
	private String username;

	// Default constructor for JPA
	Account() {}

	public Account(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public Set<Listing> getListings() {
		return listings;
	}

	public String getUsername() {
		return username;
	}
}
