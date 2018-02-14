package catan;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DevCards deck = new DevCards();
		Hand start = new Hand(0,0,0,0,0);
		Player player1 = new Player(1, start);
		player1.giveBrick(2);
		System.out.println(player1);
		player1.setSheep(15);
		player1.giveDevCard(deck.drawDev());
		player1.giveDevCard(deck.drawDev());
		player1.giveDevCard(deck.drawDev());
		player1.giveDevCard(deck.drawDev());
		System.out.println(player1);
	}

}
