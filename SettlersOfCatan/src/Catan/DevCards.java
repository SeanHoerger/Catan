package catan;

import java.util.Random;
import java.util.ArrayList;

public class DevCards {
	/**
	 * Information on the cards 1 = knight 2 = VP 3 = Road builder 4 = Year of
	 * Plenty 5 = Monopoly
	 */
	private ArrayList<Integer> cards = new ArrayList<Integer>(25);

	/**
	 * Constructor Only needs base case because we know how many cards are in the
	 * deck Deck contains 15 knights 5 VPs 2 Road builders 2 Years of Plenty 2
	 * Monopolys
	 */
	public DevCards() {
		for (int i = 0; i < 25; i++) {
			if (i < 15) {
				cards.add(1);
			} else if (i < 20) {
				cards.add(2);
			} else if (i < 22) {
				cards.add(3);
			} else if (i < 24) {
				cards.add(4);
			} else {
				cards.add(5);
			}
		}
		this.shuffle();
	}

	/**
	 * We don't need getters or setters for dev cards
	 */
	public void shuffle() {
		ArrayList<Integer> holder = new ArrayList<Integer>(cards.size());
		Random rand = new Random();
		while (cards.size() > 0) {
			int index = rand.nextInt(cards.size());
			int counter = 0;
			holder.add(cards.get(index));
			counter++;
			cards.remove(index);
		}
		cards.addAll(holder);
	}

	/**
	 * toString method
	 */
	public String toString() {
		return cards.toString();
	}

	/**
	 * Basic functionality
	 */
	public int drawDev() {
		int output = cards.get(0);
		cards.remove(0);
		return output;
	}
}
