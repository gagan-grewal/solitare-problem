package com.mergemarket.solitaire.game;

import static org.junit.Assert.*;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.mergemarket.solitaire.model.Card;

public class SolitaireGameTest {

	@Test
	public void testBasicSanity() {
		// Test to make sure that both the stock and the tableau do not have
		// same cards and both tableau and stock have the correct number of
		// cards in them
		SolitaireGame solitaireGame = new SolitaireGame();
		solitaireGame.initialSetup();
		List<ArrayDeque<Card>> tableau = solitaireGame.getTableau();
		Collection<Card> stock = solitaireGame.getStock();
		HashSet<Card> uniquenessTester = new HashSet<>();

		int cardsInStock = 0;
		for (Card card : stock) {
			++cardsInStock;
			assertTrue(uniquenessTester.add(card));
		}
		assertEquals(24, cardsInStock);

		int cardsInTab = 0;
		for (ArrayDeque<Card> arrayDeque : tableau) {
			for (Card card : arrayDeque) {
				++cardsInTab;
				assertTrue(uniquenessTester.add(card));
			}
		}
		assertEquals(28, cardsInTab);
	}

}
