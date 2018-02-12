package catan;


// this class represents a player

public class Player {
	/**
	 * Number of resource cards of each type
	 */
	private int wood;
	private int brick;
	private int sheep;
	private int wheat;
	private int iron;
	
	/**
	 * Constructors
	 */
	public Player(int newWood, int newBrick, int newSheep, int newWheat, int newIron) {
		this.wood = newWood;
		this.brick = newBrick;
		this.sheep = newSheep;
		this.wheat = newWheat;
		this.iron = newIron;
	}
	
	public Player() {
		this.wood = 0;
		this.brick = 0;
		this.sheep = 0;
		this.wheat = 0;
		this.iron = 0;
	}
	
	
	/**
	 * To String
	 */
	public String toString() {
		return "(Wood: " + wood + ", Brick: " + brick + ", Sheep: " + sheep 
				+ ", Wheat: " + wheat + ", Iron: " + iron + ", Total: " + this.getTotal() + " )";
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
	
	public int getTotal() {
		return wood + brick + sheep + wheat + iron;
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
