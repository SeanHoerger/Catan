package catan;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

// This class acts as the brain of the game. This is where all the data is stored and computed.

public class BoardData{
	private final int NUM_TILES = 19; // the number of tiles in the game
	private int[] numbers = {2,3,3,4,4,5,5,6,6,8,8,9,9,10,10,11,11,12}; // the number values in the game
	private boolean[][] boardMatrix; //adjacency matrix that shows edges 
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
				tiles[i].setHasRobber(true);
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
	public void setLocations() {
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
	void addEdge(int i, int j) {
        boardMatrix[i][j] = true;
    }
    void removeEdge(int i, int j) {
        boardMatrix[i][j] = false;
    }
    boolean hasEdge(int i, int j) {
        return boardMatrix[i][j];
    }
 /* Makes the board adjacency matrix 
   Adds the edges in the following way: 
   Counterclockwise edge, clockwise edge, connection to different loop (if connection exists)
   
   The board is numbered same as http://www.graphgraph.com/page/2/ see the second graph on the page
   Grant also has a picture of this saved on phone in case website goes down 
   */
	private void boardGenerator( ) {
		this.addEdge(1,6);
		this.addEdge (1,2);
		this.addEdge (1,24);
		this.addEdge (2,1);
		this.addEdge (2,3);
		this.addEdge (2,9);
		this.addEdge (3,2);
		this.addEdge (3,4);
		this.addEdge (3,12);
		this.addEdge (4,3);
		this.addEdge (4,5);
		this.addEdge (4,15);
		this.addEdge (5,4);
		this.addEdge (5,6);
		this.addEdge (5,18);
		this.addEdge (6,5);
		this.addEdge (6,1);
		this.addEdge (6,21);
		this.addEdge (7,24);
		this.addEdge (7,8);
		this.addEdge (7,25);
		this.addEdge (8,7);
		this.addEdge (8,9);
		this.addEdge (8,28);
		this.addEdge (9,8);
		this.addEdge (9,10);
		this.addEdge (9,2);
		this.addEdge (10,9);
		this.addEdge (10,11);
		this.addEdge (10,30);
		this.addEdge (11,10);
		this.addEdge (11,12);
		this.addEdge (11,33);
		this.addEdge (12,11);
		this.addEdge (12,12);
		this.addEdge (12,3);
		this.addEdge (13,12);
		this.addEdge (13,14);
		this.addEdge (13,35);
		this.addEdge (14,13);
		this.addEdge (14,15);
		this.addEdge (14,38);
		this.addEdge (15,14);
		this.addEdge (15,16);
		this.addEdge (15,4);
		this.addEdge (16,15);
		this.addEdge (16,17);
		this.addEdge (16,40);
		this.addEdge (17,16);
		this.addEdge (17,18);
		this.addEdge (17,43);
		this.addEdge (18,17);
		this.addEdge (18,19);
		this.addEdge (18,5);
		this.addEdge (19,18);
		this.addEdge (19,20);
		this.addEdge (19,45);
		this.addEdge (20,19);
		this.addEdge (20,21);
		this.addEdge (20,48);
		this.addEdge (21,20);
		this.addEdge (21,22);
		this.addEdge (21,6);
		this.addEdge (22,21);
		this.addEdge (22,23);
		this.addEdge (22,50);
		this.addEdge (23,22);
		this.addEdge (23,24);
		this.addEdge (23,53);
		this.addEdge (24,23);
		this.addEdge (24,7);
		this.addEdge (24,1);
		this.addEdge (25,54);
		this.addEdge (25,26);
		this.addEdge (25,7);
		this.addEdge (26,25);
		this.addEdge (26,27);
		this.addEdge (27,26);
		this.addEdge (27,28);
		this.addEdge (28,27);
		this.addEdge (28,29);
		this.addEdge (28,8);
		this.addEdge (29,28);
		this.addEdge (29,30);
		this.addEdge (30,29);
		this.addEdge (30,31);
		this.addEdge (30,10);
		this.addEdge (31,30);
		this.addEdge (31,32);
		this.addEdge (32,31);
		this.addEdge (32,33);
		this.addEdge (33,32);
		this.addEdge (33,34);
		this.addEdge (33,11);
		this.addEdge (34,33);
		this.addEdge (34,35);
		this.addEdge (35,34);
		this.addEdge (35,36);
		this.addEdge (35,13);
		this.addEdge (36,35);
		this.addEdge (36,37);
		this.addEdge (37,36);
		this.addEdge (37,38);
		this.addEdge (38,37);
		this.addEdge (38,39);
		this.addEdge (38,14);
		this.addEdge (39,38);
		this.addEdge (39,40);
		this.addEdge (40,39);
		this.addEdge (40,41);
		this.addEdge (40,16);
		this.addEdge (41,40);
		this.addEdge (41,42);
		this.addEdge (42,41);
		this.addEdge (42,43);
		this.addEdge (43,42);
		this.addEdge (43,44);
		this.addEdge (43,17);
		this.addEdge (44,43);
		this.addEdge (44,45);
		this.addEdge (45,44);
		this.addEdge (45,46);
		this.addEdge (45,19);
		this.addEdge (46,45);
		this.addEdge (46,47);
		this.addEdge (47,46);
		this.addEdge (47,48);
		this.addEdge (48,47);
		this.addEdge (48,49);
		this.addEdge (48,20);
		this.addEdge (49,48);
		this.addEdge (49,50);
		this.addEdge (50,49);
		this.addEdge (50,51);
		this.addEdge (50,22);
		this.addEdge (51,50);
		this.addEdge (51,52);
		this.addEdge (52,51);
		this.addEdge (52,53);
		this.addEdge (53,52);
		this.addEdge (53,54);
		this.addEdge (53,23);
		this.addEdge (54,53);
		this.addEdge (54,25);		
	}
}
