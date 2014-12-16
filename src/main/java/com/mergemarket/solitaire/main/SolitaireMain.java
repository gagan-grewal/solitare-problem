package com.mergemarket.solitaire.main;

import com.mergemarket.solitaire.game.SolitaireGame;

public class SolitaireMain {

	public static void main(String[] args) {
		SolitaireGame solitaire = new SolitaireGame();
		solitaire.displaySolitaire();
		solitaire.initialSetup();
		solitaire.displaySolitaire();
	}

}
