package com.mergemarket.solitaire.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.mergemarket.solitaire.model.Card;
import com.mergemarket.solitaire.model.CardName;
import com.mergemarket.solitaire.model.SolitaireDisplayHelper;
import com.mergemarket.solitaire.model.Suit;

/*
 * The type representing the game after a deck has been dealt and the cards have been laid out as required by the game
 */
public class SolitaireGame {
	// Convenience constant
	private static final int						TABLEAU_SIZE		= 7;

	// Number of cards in stock = number of cards in deck - number of cards in
	// tableau
	// Number of cards in stock = 52 - 28
	private static final int						NUM_CARDS_IN_STOCK	= 24;

	// a flag to indicate whether an initial setup has been done or not
	private boolean									isSetupDoneOnce		= false;

	// The four Foundation stacks which can be built by Suit
	//
	// Passing in a capacity of 8 which may be sufficient to accommodate
	// collisions across 4 Suit keys
	private final HashMap<Suit, ArrayDeque<Card>>	foundation			= new HashMap<>(8);

	// The seven Tableau stacks
	//
	// Initialize the array list to size since we only have 7 Tableaus
	private final ArrayList<ArrayDeque<Card>>		tableau				= new ArrayList<>(7);

	// The stack of cards representing stock
	private final ArrayDeque<Card>					stock				= new ArrayDeque<>();

	// A 4x13 array of booleans which will be used to mark whether a card has
	// been picked up already or not
	private final boolean							picked[][]			= new boolean[4][13];
	private final boolean[]							initialiser			= new boolean[13];

	// Default constructor
	public SolitaireGame() {
		// Initialize the Tableau to empty stacks for convenience
		for (int i = 0; i < TABLEAU_SIZE; i++) {
			tableau.add(new ArrayDeque<>());
		}

		// Initialize the Foundation to empty stacks for convenience
		foundation.put(Suit.D, new ArrayDeque<>());
		foundation.put(Suit.H, new ArrayDeque<>());
		foundation.put(Suit.s, new ArrayDeque<>());
		foundation.put(Suit.c, new ArrayDeque<>());
	}

	// The method which represents dealing a deck into Foundations and Stock
	public void initialSetup() {
		// Initialize all cards as not picked
		for (int i = 0; i < picked.length; i++) {
			System.arraycopy(initialiser, 0, picked[i], 0, initialiser.length);
		}

		// Initialize the Tableau to empty stacks
		for (ArrayDeque<Card> stack : tableau) {
			stack.clear();
		}

		// Initialize the Foundations to empty stacks
		Iterator<ArrayDeque<Card>> foundationItr = foundation.values().iterator();
		while (foundationItr.hasNext()) {
			foundationItr.next().clear();
		}

		Suit[] suits = Suit.values();
		CardName[] cardNames = CardName.values();

		int suitIdx;
		int cardIdx;
		Random rnd = new Random();

		// Build the Tableau
		for (int i = 0; i < tableau.size(); i++) {
			ArrayDeque<Card> stack = tableau.get(i);
			for (int j = 0; j < (i + 1); j++) {
				suitIdx = rnd.nextInt(4);
				cardIdx = rnd.nextInt(13);
				while (!isCardAvailable(suitIdx, cardIdx)) {
					suitIdx = rnd.nextInt(4);
					cardIdx = rnd.nextInt(13);
				}
				stack.push(new Card(suits[suitIdx], cardNames[cardIdx]));
			}
		}

		// Use the cards which were not added to Tableau to build the Stock
		for (int i = 0; i < NUM_CARDS_IN_STOCK; i++) {
			suitIdx = rnd.nextInt(4);
			cardIdx = rnd.nextInt(13);
			while (!isCardAvailable(suitIdx, cardIdx)) {
				suitIdx = rnd.nextInt(4);
				cardIdx = rnd.nextInt(13);
			}
			stock.push(new Card(suits[suitIdx], cardNames[cardIdx]));
		}

		isSetupDoneOnce = true;
	}

	/*
	 * Check if a card is available and mark that card as unavailable
	 */
	private boolean isCardAvailable(int suit, int card) {
		if (!picked[suit][card]) {
			picked[suit][card] = true;
			return true;
		}
		return false;
	}

	/*
	 * Display the Solitaire game
	 */
	public void displaySolitaire() {
		if (isSetupDoneOnce) {
			SolitaireDisplayHelper.displaySolitaire(foundation, stock, tableau);
		}
	}

	/*
	 * Package accessible methods for testing
	 */
	List<ArrayDeque<Card>> getTableau() {
		return Collections.unmodifiableList(tableau);
	}

	Collection<Card> getStock() {
		return Collections.unmodifiableCollection(stock);
	}

}
