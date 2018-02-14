package catan;

public class Hand {
	/**
	 * Number of resource cards of each type
	 */

	private int wood;
	private int brick;
	private int sheep;
	private int wheat;
	private int ore;
	private int total;

	/**
	 * Constructors
	 */
	public Hand(int newWood, int newBrick, int newSheep, int newWheat, int newOre) {
		this.wood = newWood;
		this.brick = newBrick;
		this.sheep = newSheep;
		this.wheat = newWheat;
		this.ore = newOre;
		this.total = wood + brick + sheep + wheat + ore;
	}

	public Hand() {
		this.wood = 0;
		this.brick = 0;
		this.sheep = 0;
		this.wheat = 0;
		this.ore = 0;
		this.total = 0;
	}

	/**
	 * To String
	 */
	public String toString() {
		return "(Wood:" + wood + ", Brick:" + brick + ", Sheep:" + sheep + ", Wheat:" + wheat
				+ ", Ore:" + ore + ", Total:" + total + ")";
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
}
