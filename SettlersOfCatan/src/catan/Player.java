package catan;

import java.awt.Graphics;
import java.util.Random;

/**
 * This Class stores all the necessary information of a player
 * Completed:
 * 			Player Number
 * 			Hand
 * 			Dev Cards
 * TODO:
 * 			Settlements
 * 			Cities
 * 			Roads
 * @author andro
 *
 */

public class Player{
	/**
	 * Number of resource cards of each type
	 * Hand class to store resources
	 * Initialize a devCard holder to all 0 (0 = no dev card)
	 */
	private int playerNum;
	private Hand hand;
	private int[] devCards = new int[25];

	/**
	 * Constructors
	 */
	public Player(int playerNumber, Hand newHand) {
		this.playerNum = playerNumber;
		this.hand = newHand;
	}

	public Player(int playerNumber) {
		this.playerNum = playerNumber;
		this.hand = new Hand(0,0,0,0,0);
	}
	
	public Player() {
		this.hand = new Hand(0,0,0,0,0);
		this.playerNum = 0;
	}

	/**
	 * To String
	 */
	@Override
	public String toString() {
		String devString = "(";
		for(int i = 0; i<this.indexOfLastDev(); i++) {
			devString = devString + devCards[i];
			if(i < this.indexOfLastDev() - 1) {
				devString = devString + ",";
			}
		}
		devString = devString + ")";
		return "(Player:" + playerNum + ", Hand:" + hand.toString() + ", DevCards:" + devString + ")";
	}

	/**
	 * Getters
	 */
	public int getWood() {
		return hand.getWood();
	}

	public int getBrick() {
		return hand.getBrick();
	}

	public int getSheep() {
		return hand.getSheep();
	}

	public int getWheat() {
		return hand.getWheat();
	}

	public int getIron() {
		return hand.getOre();
	}

	public int getTotal() {
		return hand.getTotal();
	}

	/**
	 * Setters
	 */

	public void setWood(int newWood) {
		hand.setWood(newWood);
	}

	public void setBrick(int newBrick) {
		hand.setBrick(newBrick);
	}

	public void setSheep(int newSheep) {
		hand.setSheep(newSheep);
	}

	public void setWheat(int newWheat) {
		hand.setWheat(newWheat);
	}

	public void setOre(int newOre) {
		hand.setOre(newOre);
	}

	/**
	 * Basic Functions Give
	 */
	public void giveWood(int newWood) {
		hand.giveWood(newWood);
	}

	public void giveBrick(int newBrick) {
		hand.giveBrick(newBrick);
	}

	public void giveSheep(int newSheep) {
		hand.giveSheep(newSheep);
	}

	public void giveWheat(int newWheat) {
		hand.giveWheat(newWheat);
	}

	public void giveOre(int newOre) {
		hand.giveOre(newOre);
	}
	
	/**
	 * Basic functions to manipulate and add/remove dev cards
	 */
	public int[] getDevCards() {
		return devCards;
	}
	
	/**
	 * Returns true if the player has the indicated dev card
	 * Uses a flag to signal the end of the while loop
	 * Checks each element to see if it contains the indicated dev card
	 * If it does, return true, else it iterates through the loop until the devCard list is empty
	 */
	public boolean hasDevCard(int devCard) {
		int flag = 0;
		int counter = 0;
		while(flag == 0) {
			if(devCards[counter] == devCard) {
				return true;
			}
			if(devCards[counter] == 0) {
				flag++;
			}
		}
		return false;
	}
	
	/**
	 * Gives the player the indicated dev card
	 * Adds the dev card to the first 0 spot in devCards
	 * (The first slot not already assigned to a different dev card)
	 */
	public void giveDevCard(int devCard) {
		int flag = 0;
		int counter = 0;
		while(flag == 0) {
			if(devCards[counter] == 0) {
				devCards[counter] = devCard;
				flag++;
			}
			else {
				counter++;
			}
		}
	}
	
	/**
	 * Returns the index of the last assigned dev card
	 * Uses a flag to keep track of the loop
	 * While the last dev card has not been found
	 * Check if the spot in dev card is empty, if not increment the counter
	 */
	public int indexOfLastDev() {
		int counter = 0;
		int flag = 0;
		while(flag == 0) {
			if(devCards[counter] == 0){
				flag++;
			}
			else{
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Removes the indicated dev card from the array
	 * Uses a flag to indicate the end of the loop
	 */
	public void removeDevCard(int devCard) {
		int counter = 0;
		int flag = 0;
		while(flag == 0) {
			if(devCards[counter] == devCard) {  // Checks to see if this position holds the indicated dev card
				devCards[counter] = devCards[this.indexOfLastDev()];  	// Switches the position of the current spot and the last dev card in the array
				devCards[this.indexOfLastDev()] = 0;					// Removes the last dev card in the array (saved this dev card in the previous line)
				flag++;
			}
			else if(devCards[counter] == 0) {  	// If the rest of the array is empty, end the loop
				flag++;
			}
			else {								// else increment the loop
				counter++;
			}
		}
	}
	
	public void displayHand(Graphics g) {
		hand.display(g);
	}
}
