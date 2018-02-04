package Catan;

public class Tile {

	/**Position of the tile on the board
	 * 0th tile is the top left of the hexagon moving in horizontal rows
	 * 18th tile is the bottom right
	 */
	private int position;
	
	/**Int representing which resource the tile gives when rolled
	 * 0 == wood; 1 == brick; 2 == wheat; 3 == sheep; 4 == iron, 5 == desert
	 */
	private int tileType;
	
	/**The number on the tile */
	private int number;
	
	/**false == noRobber, true == hasRobber */
	private boolean hasRobber = false;
	
	/**
	 * Constructors
	 */
	public Tile (int inputPosition, int inputTileType, int inputNumber, boolean inputHasRobber) {
		this.position = inputPosition;
		this.tileType = inputTileType;
		this.number = inputNumber;
		this.hasRobber = inputHasRobber;
	}
	
	public Tile() {
		this.position = 0;
		this.tileType = 0;
		this.number = 0;
		this.hasRobber = false;
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		return "(" + this.getPosition() + " , " + this.getTileType() + " , " + this.getNumber()
		       + " , " + this.hasRobber() + ")";
	}
	
	/**
	 * Getters
	 * access basic information
	 */
	public int getPosition() {
		return this.position;
	}
	
	public int getTileType() {
		return this.tileType;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public boolean hasRobber() {
		return this.hasRobber;
	}
	
	/**
	 * Setters
	 * Set basic information
	 */
	public void setPosition(int newPosition) {
		this.position = newPosition;
	}
	
	public void setTileType(int newType) {
		this.tileType = newType;
	}
	
	public void setNumber(int newNumber) {
		this.number = newNumber;
	}
	
	public void setHasRobber(boolean newRobber) {
		this.hasRobber = newRobber;
	}

}
