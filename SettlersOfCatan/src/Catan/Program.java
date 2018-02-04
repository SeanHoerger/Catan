package Catan;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DevCards deck = new DevCards();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		deck.drawDev();
		deck.drawDev();
		deck.drawDev();
		System.out.println(deck);
	}

}
