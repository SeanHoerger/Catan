package catan;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


// This class acts as the brain of the game. This is where all the data is stored and computed.

public class BoardData{
	private final int NUM_TILES = 19; // the number of tiles in the game
	private int[] numbers = {2,3,3,4,4,5,5,6,6,8,8,9,9,10,10,11,11,12}; // the number values in the game
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private Tile[] tiles = new Tile[NUM_TILES]; // an array that holds all the tiles in the game
	
	// default (no argument) constructor
	public BoardData() {
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		player4 = new Player();
		
		//gives each of the tiles its proper color and type
		for (int i = 0; i < NUM_TILES; i++) {
			tiles[i] = new Tile();
			
			if (i < 4) { // wood (default)
				tiles[i].setColor(new Color(0,100,0));
			}
			else if (i < 7) { // brick - 1
				tiles[i].setColor(new Color(183,90,0));
				tiles[i].setTileType(1);
			}
			else if (i < 11) { // wheat - 2
				tiles[i].setColor(new Color(255,234,1));
				tiles[i].setTileType(2);
			}
			else if (i < 15) { // sheep - 3
				tiles[i].setColor(new Color(42,234,71));
				tiles[i].setTileType(3);
			}
			else if (i < 18) { // iron - 4
				tiles[i].setColor(new Color(101,101,165));
				tiles[i].setTileType(4);
			}
			else {// desert - 5
				tiles[i].setColor(new Color(200,175,100));
				tiles[i].setTileType(5);
			}
		}
		this.shuffleTiles(); // randomizes the order of the tiles
		this.setLocations(); // sets the location of the tiles on the board
		this.shuffleNumbers(); // randomizes and assigns the numbers to the tiles
	}
	
	// returns the array of tiles
	public Tile[] getTiles() {
		return this.tiles;
	}
	
	// returns the tile at index i in the array of tiles
	public Tile getTileAt(int i) {
		if (i < NUM_TILES) {
			return tiles[i];
		}
		return null;
	}
	
	// randomizes the order of the tiles
	public void shuffleTiles() {
		int length = tiles.length;
		ArrayList<Tile> copy = new ArrayList<Tile>();
		Tile[] shuffled = new Tile[length];
		for(int i = 0; i < length; i++) {
			copy.add(tiles[i]);
		}
		
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int n = rand.nextInt(copy.size());
			shuffled[i] = copy.get(n);
			copy.remove(n);
		}
		this.tiles = shuffled;
	}
	
	// randomizes and assigns the numbers to the tiles
	public void shuffleNumbers() {
		int length = numbers.length;
		ArrayList<Integer> copy = new ArrayList<Integer>();
		int[] shuffled = new int[length];
		for(int i = 0; i < length; i++) {
			copy.add(numbers[i]);
		}
		
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			int n = rand.nextInt(copy.size());
			shuffled[i] = copy.get(n);
			copy.remove(n);
		}
		this.numbers = shuffled;
		
		int numberCounter = 0;
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i].getTileType() !=5) {
				tiles[i].setNumber(numbers[numberCounter]);
				numberCounter++;
			}
		}
	}
	
	// sets the location of the tiles on the board
	private void setLocations() {
		int xPos = BoardDisplay.XSTART;
		int yPos = BoardDisplay.YSTART;
		int i = 0;
		
		// row one - 3 tiles
		for(int r1 = 0; r1 < 3; r1++) {
			tiles[i].setLocation(new Location(xPos, yPos));
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-3*BoardDisplay.SCALAR;
		yPos = yPos+5*BoardDisplay.SCALAR;
		
		//row two - 4 tiles
		for(int r2 = 0; r2 < 4; r2++) {
			tiles[i].setLocation(new Location(xPos, yPos));
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-6*BoardDisplay.SCALAR;
		yPos = yPos+5*BoardDisplay.SCALAR;
		
		//row three - 5 tiles
		for(int r3 = 0; r3 < 5; r3++) {
			tiles[i].setLocation(new Location(xPos, yPos));
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-3*BoardDisplay.SCALAR;
		yPos = yPos+5*BoardDisplay.SCALAR;
		
		// row four - 4 tiles
		for(int r4 = 0; r4 < 4; r4++) {
			tiles[i].setLocation(new Location(xPos, yPos));
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART;
		yPos = yPos+5*BoardDisplay.SCALAR;
		
		// row five - 3 tiles
		for(int r5 = 0; r5 < 3; r5++) {
			tiles[i].setLocation(new Location(xPos, yPos));
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		
		
	}
}
