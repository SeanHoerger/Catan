package catan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Hand {
	/**
	 * Number of resource cards of each type
	 */

	private int wood;
	private int brick;
	private int sheep;
	private int wheat;
	private int ore;

	/**
	 * Constructors
	 */
	public Hand(int newWood, int newBrick, int newSheep, int newWheat, int newOre) {
		this.wood = newWood;
		this.brick = newBrick;
		this.sheep = newSheep;
		this.wheat = newWheat;
		this.ore = newOre;
	}

	public Hand() {
		this.wood = 0;
		this.brick = 0;
		this.sheep = 0;
		this.wheat = 0;
		this.ore = 0;
	}

	/**
	 * To String
	 */
	@Override
	public String toString() {
		return "(Wood:" + wood + ", Brick:" + brick + ", Sheep:" + sheep + ", Wheat:" + wheat
				+ ", Ore:" + ore + ", Total:" + this.getTotal() + ")";
	}

	/**
	 * Getters
	 */
	public int getWood() {
		return wood;
	}

	public int getBrick() {
		return brick;
	}

	public int getSheep() {
		return sheep;
	}

	public int getWheat() {
		return wheat;
	}

	public int getOre() {
		return ore;
	}
	
	public int getTotal() {
		return wood + brick + wheat + sheep + ore;
	}

	/**
	 * Setters
	 */

	public void setWood(int newWood) {
		this.wood = newWood;
	}

	public void setBrick(int newBrick) {
		this.brick = newBrick;
	}

	public void setSheep(int newSheep) {
		this.sheep = newSheep;
	}

	public void setWheat(int newWheat) {
		this.wheat = newWheat;
	}

	public void setOre(int newOre) {
		this.ore = newOre;
	}

	/**
	 * Basic Functions Give resources
	 */
	public void giveWood(int newWood) {
		this.wood += newWood;
	}

	public void giveBrick(int newBrick) {
		this.brick += newBrick;
	}

	public void giveSheep(int newSheep) {
		this.sheep += newSheep;
	}

	public void giveWheat(int newWheat) {
		this.wheat += newWheat;
	}

	public void giveOre(int newOre) {
		this.ore += newOre;
	}
	
	// displays the cards in the hand
	public void display(Graphics g) {
	
		int x = BoardDisplay.XDIM - 18*BoardDisplay.SCALAR;
		int y = 13*BoardDisplay.SCALAR;
		
		// dimension of card + boarder
		int xAdjust = 6*BoardDisplay.SCALAR; 
		int yAdjust = 8*BoardDisplay.SCALAR;
		
		//wood
		this.drawCard(g, x + 1*xAdjust, y, this.getWood(), new Color(0, 100 , 0));
		
		//brick
		this.drawCard(g, x + 2*xAdjust, y, this.getBrick(), new Color(183, 90, 0));
		
		//wheat
		this.drawCard(g, x + 1*xAdjust, y + yAdjust, this.getWheat(), new Color(255, 234, 1));
		
		//sheep
		this.drawCard(g, x + 2*xAdjust, y + yAdjust, this.getSheep(), new Color(0, 255, 38));
		
		//ore
		this.drawCard(g, x, y + yAdjust, this.getOre(), new Color(101, 101, 165));
	}
	
	private void drawCard(Graphics g, int x, int y, int n, Color cardColor) {
		//draw card
		g.setColor(Color.WHITE);
		g.fillRect(x, y, (5*BoardDisplay.SCALAR), (7*BoardDisplay.SCALAR));
		
		if (n == 0) {
			//g.setColor(new Color(75, 100, 75)); <-- work on gray-out later
			g.setColor(Color.GRAY);
		}
		else {
			g.setColor(cardColor);
		}
		g.fillRect(x + (int)(0.5*BoardDisplay.SCALAR), y + (int)(0.5*BoardDisplay.SCALAR), 4*BoardDisplay.SCALAR, 6*BoardDisplay.SCALAR);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, (5*BoardDisplay.SCALAR), (7*BoardDisplay.SCALAR));
		g.drawRect(x + (int)(0.5*BoardDisplay.SCALAR), y + (int)(0.5*BoardDisplay.SCALAR), 4*BoardDisplay.SCALAR, 6*BoardDisplay.SCALAR);
		
		//draw number
		g.setColor(Color.WHITE);
		if (n < 10){
			g.setFont(new Font (Font.SANS_SERIF, Font.BOLD, (int)(5*BoardDisplay.SCALAR)));	
			g.drawString("" + n, x + (int)(0.9*BoardDisplay.SCALAR), y+(int)(5.5*BoardDisplay.SCALAR));
		}
		else {
			g.setFont(new Font (Font.SANS_SERIF, Font.BOLD, (int)(2.5*BoardDisplay.SCALAR)));
			g.drawString("" + n, x + (int)(0.9*BoardDisplay.SCALAR), y+(int)(4.5*BoardDisplay.SCALAR));
		}
	}
}
