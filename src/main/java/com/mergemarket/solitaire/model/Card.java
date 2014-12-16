package com.mergemarket.solitaire.model;

/*
 * The type representing a Card which is of the form {Suit,CardName}
 */
public class Card {
	private final Suit		suit;
	private final CardName	cardName;
	private final String	toStr;

	public Card(Suit suit, CardName cardName) {
		this.suit = suit;
		this.cardName = cardName;
		toStr = this.suit.toString() + this.cardName.toString();
	}

	@Override
	public String toString() {
		return toStr;
	}

	@Override
	public int hashCode() {
		return (51 * cardName.ordinal() + suit.ordinal()) % 8;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (!(obj instanceof Card)) {
			return false;
		}

		Card otherCard = (Card) obj;

		if (this == otherCard)
			return true;

		return otherCard.suit == suit && otherCard.cardName == cardName;
	}

}
