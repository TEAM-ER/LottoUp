package com.teamericray.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Listing {

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Account account;

	private Double targetPrice;
	private Integer numOfTickets;

	// Default constructor for JPA
	Listing() {}

	public Listing(Account account, Double targetPrice, Integer numOfTickets) {
		this.account = account;
		this.targetPrice = targetPrice;
		this.numOfTickets = numOfTickets;
	}

	public Long getId() {
		return id;
	}

	public Account getAccount() {
		return account;
	}

	public Double getTargetPrice() {
		return targetPrice;
	}

	public Integer getNumOfTickets() {
		return numOfTickets;
	}
}
