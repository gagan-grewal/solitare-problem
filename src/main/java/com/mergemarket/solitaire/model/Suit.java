package com.mergemarket.solitaire.model;

/*
 * A enumeration representing the types of Suits which are available in the deck
 */
public enum Suit {
	D("D"),
	H("H"), 
	c("c"), 
	s("s");

	// A simple description of the Suit
	private final String	description;

	Suit(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description;
	}
}
