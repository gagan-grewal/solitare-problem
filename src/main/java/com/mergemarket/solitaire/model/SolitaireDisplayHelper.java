package com.mergemarket.solitaire.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class SolitaireDisplayHelper {
	private static final String	FMT_HEADER				= "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t[%s]\t[%s]\t[%s]\t[%s]\n";
	private static final String	HEADER_ARG_STACK		= "S[T]ack";
	private static final String	HEADER_ARG_COLUMN_NAMES	= "ColumnNames";
	private static final String	HEADER_ARG_FND_1		= "[1]";
	private static final String	HEADER_ARG_FND_2		= "[2]";
	private static final String	HEADER_ARG_FND_3		= "[3]";
	private static final String	HEADER_ARG_FND_4		= "[4]";
	private static final String	HEADER_ARG_FND_5		= "[5]";
	private static final String	HEADER_ARG_FND_6		= "[6]";
	private static final String	HEADER_ARG_FND_7		= "[7]";
	private static final String	HEADER_SEPARATOR		= "-----------------------------------------------------------------------------------------------------------";

	private static final String	TAB_ROW_1				= "\t\t\t%3s\t **\t **\t **\t **\t **\t **\n";
	private static final String	TAB_ROW_2				= "\t\t\t\t%3s\t **\t **\t **\t **\t **\n";
	private static final String	TAB_ROW_3				= "\t\t\t\t\t%3s\t **\t **\t **\t **\n";
	private static final String	TAB_ROW_4				= "\t\t\t\t\t\t%3s\t **\t **\t **\n";
	private static final String	TAB_ROW_5				= "\t\t\t\t\t\t\t%3s\t **\t **\n";
	private static final String	TAB_ROW_6				= "\t\t\t\t\t\t\t\t%3s\t **\n";
	private static final String	TAB_ROW_7				= "\t\t\t\t\t\t\t\t\t%3s\n";
	private static final String	TAB_ROWS[]				= new String[] { TAB_ROW_1, TAB_ROW_2, TAB_ROW_3, TAB_ROW_4,
			TAB_ROW_5, TAB_ROW_6, TAB_ROW_7			};

	public static void displaySolitaire(HashMap<Suit, ArrayDeque<Card>> foundation, ArrayDeque<Card> stock,
			ArrayList<ArrayDeque<Card>> tableau) {
		System.out.printf(FMT_HEADER, HEADER_ARG_COLUMN_NAMES, HEADER_ARG_STACK, HEADER_ARG_FND_1, HEADER_ARG_FND_2,
				HEADER_ARG_FND_3, HEADER_ARG_FND_4, HEADER_ARG_FND_5, HEADER_ARG_FND_6, HEADER_ARG_FND_7, Suit.D,
				Suit.H, Suit.c, Suit.s);
		System.out.println();
		System.out.println(HEADER_SEPARATOR);
		Card fndD = foundation.get(Suit.D).peek();
		Card fndH = foundation.get(Suit.H).peek();
		Card fndC = foundation.get(Suit.c).peek();
		Card fndS = foundation.get(Suit.s).peek();
		System.out.printf("\t\t%7s\t\t\t\t\t\t\t\t%3s\t%3s\t%3s\t%3s\n", stock.peek(), fndD == null ? "" : fndD,
				fndH == null ? "" : fndH, fndC == null ? "" : fndC, fndS == null ? "" : fndS);

		for (int i = 0; i < 7; i++) {
			System.out.printf(TAB_ROWS[i], tableau.get(i).peek());
		}
	}
}
