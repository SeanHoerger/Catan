package catan;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * This Class stores all the necessary information of a player
 * Completed:
 * 			Player Number
 * 			Hand
 * 			Dev Cards
 * TODO:
 * 			Settlements   5
 * 			Cities        4
 * 			Roads		 15
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
	private String playerName;
	private int building = 0; //Keeps track if the player is building. 0 = no, 1 = road, 2 = settlement, 3 = city
	private ArrayList<Road> roadList;
	private ArrayList<House> houseList;
	private int roadsLeft = 15;
	private int settlementsLeft = 5;
	private int citiesLeft = 4;
	
	
	/**
	 * Constructors
	 */
	public Player(int playerNumber, Hand newHand) {
		this.playerNum = playerNumber;
		this.hand = newHand;	
		roadList = new ArrayList<Road>();
		houseList = new ArrayList<House>();
	}

	public Player(int playerNumber) {
		this.playerNum = playerNumber;
		this.hand = new Hand(0,0,0,0,0);
		roadList = new ArrayList<Road>();
		houseList = new ArrayList<House>();
	}
	
	public Player() {
		this.hand = new Hand(0,0,0,0,0);
		this.playerNum = 0;
		roadList = new ArrayList<Road>();
		houseList = new ArrayList<House>();
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
		return "(Player:" + playerNum + ", Hand:" + hand.toString() + ", DevCards:" + devString + "NumHouses: " + houseList.size() + ")";
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

	public int getOre() {
		return hand.getOre();
	}

	public int getTotal() {
		return hand.getTotal();
	}
	
	public String getName() {
		return playerName;
	}

	public int getNumber() {
		return playerNum;
	}
	
	public int getBuilding() {
		return building;
	}
	
	public ArrayList<House> getHouseList(){
		return houseList;
	}
	
	public Color getColor() {
		if (playerNum == 1) {
			return Color.BLUE;
		}
		else if (playerNum == 2) {
			return Color.WHITE;
		}
		else if(playerNum == 3) {
			return new Color(255, 150, 0);
		}
		else {
			return Color.RED;
		}
	}

	public ArrayList<Road> getRoads() {
		return roadList;
	}
	
	// Used to keep track of the current number of roads and ensure that the number is less than 15
	public int getNumRoads() {
		return (15 - roadsLeft);
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
	
	public void setName(String name) {
		playerName = name;
	}
	
	public void setBuilding(int type) {
		building = type;
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
	
	public int numDevCards() {
		return this.indexOfLastDev();
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
	
	/**
	 * Boolean methods to return if the player can build certain objects
	 */
	
	public boolean canBuildRoad() {
		if(hand.getBrick()> 0 && hand.getWood() > 0 && roadsLeft > 0) {
			return true;
		}
		return false;
	}
	
	public boolean canBuildSettlement() {
		if(hand.getBrick()> 0 && hand.getWood() > 0 && hand.getSheep() > 0 && hand.getWheat() >0 && settlementsLeft > 0) {
			return true;
		}
		return false;
	}
	
	public boolean canBuildCity() {
		if((hand.getWheat() > 1) && (hand.getOre() > 2) && citiesLeft > 0 && citiesLeft > 0 && settlementsLeft < 5){
			return true;
		}
		return false;
	}
	
	public boolean canBuildDevCard() {
		if(hand.getSheep()> 0 && hand.getWheat() > 0 && hand.getOre() > 0) {
			return true;
		}
		return false;
	}
	
	public void buildRoad(Vertex v1, Vertex v2) {
		if(this.canBuildRoad() == true) {
			roadList.add(new Road(v1,v2, this.getColor()));
			roadsLeft--;
		}
	}
	
	public void buildSettlement(Vertex v) {
		if (this.canBuildSettlement() == true) {
			houseList.add(new Settlement(v));
			settlementsLeft--;
		}
	}
	
	public void buildCity(Vertex v) {
		if(this.canBuildCity()) {
			for(int i = 0; i < houseList.size(); i++) {
				if(v.equals(houseList.get(i).getVertex())) {
					houseList.remove(i);
					settlementsLeft++;
					houseList.add(new City(v));
					citiesLeft--;
					break;
				}
			}
		}
	}
	
	public void drawAll(Graphics g) {
		// draw Roads
		for(int i = 0; i < roadList.size(); i++) {
			roadList.get(i).draw(g);
		}
		// draw Houses
		for(int i = 0; i < houseList.size(); i++) {
			houseList.get(i).draw(g, this.getColor());
		}
	}
	
	public void pullResources(int roll) {
		for(int i = 0; i < houseList.size(); i++) {
			House house = houseList.get(i);
			Vertex vertex = house.getVertex();
			ArrayList<Tile> neighborTiles = vertex.getNeighbors();
			for(int j = 0; j <neighborTiles.size(); i++) {
				Tile  tile = neighborTiles.get(j);
				if(tile.getNumber() == roll) {
					this.pullResources(roll, tile.getTileType(), vertex.getHouseType());
				}
			}
		}
	}
	
	private void pullResources(int roll, int type, int houseType) {
		if(type == 0) { // wood
			this.giveWood(houseType);
		}
		else if(type == 1) { // brick
			this.giveBrick(houseType);
		}
		else if(type == 2) { // wheat
			this.giveWheat(houseType);
		}
		else if(type == 3) { // sheep
			this.giveSheep(houseType);
		}
		else if(type == 4) { // ore
			this.giveOre(houseType);
		}
		else if(type == 5) { // desert
			// ha you get nothing
		}	
	}
	
	public void testAddSettlement(Vertex v) {
		this.giveWood(1);
		this.giveBrick(1);
		this.giveWheat(1);
		this.giveSheep(1);
		this.buildSettlement(v);
	}
	
}
