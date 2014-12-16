package com.mergemarket.solitaire.model;

/*
 * A simple enumeration representing the various names which can be assigned to cards in a deck
 */
public enum CardName {
	A("A"),
	_2("2"),
	_3("3"),
	_4("4"),
	_5("5"),
	_6("6"),
	_7("7"),
	_8("8"),
	_9("9"),
	T("T"),
	J("J"),
	Q("Q"),
	K("K");
	
	private final String	name;

	CardName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
