package Catan;

public class Hand {
	/**
	 * Number of resource cards of each type
	 * Player = integer representing which player the hand belongs to
	 */
	
	private int player;
	private int wood;
	private int brick;
	private int sheep;
	private int wheat;
	private int iron;
	private int total;
	
	/**
	 * Constructors
	 */
	public Hand(int playerNum, int newWood, int newBrick, int newSheep, int newWheat, int newIron) {
		this.player = playerNum;
		this.wood = newWood;
		this.brick = newBrick;
		this.sheep = newSheep;
		this.wheat = newWheat;
		this.iron = newIron;
		this.total = wood + brick + sheep + wheat + iron;
	}
	
	public Hand() {
		this.player = 0;
		this.wood = 0;
		this.brick = 0;
		this.sheep = 0;
		this.wheat = 0;
		this.iron = 0;
		this.total = 0;
	}
	/**
	 * To String
	 */
	public String toString() {
		return "(Player " + player + " , Wood " + wood + " , Brick " + brick + " , Sheep " + sheep 
				+ " , Wheat " + wheat + " , Iron " + iron + " , Total " + total + " )";
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
	
	public int getIron() {
		return iron;
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
	
	public void setIron(int newIron) {
		this.iron = newIron;
	}
	
	/**
	 * Basic Functions
	 * Give resources
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
	
	public void giveIron(int newIron) {
		this.iron += newIron;
	}
}
