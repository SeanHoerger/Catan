package catan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This class is where the visuals are displayed. It also contains the main method.

public class BoardDisplay extends JComponent{

	
	public static final int XDIM = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int YDIM = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static final int SCALAR = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 55); // <-- magic number: 55
	public static final int XSTART = 10*SCALAR;
	public static final int YSTART = (int)(1.5*SCALAR);
	//public static final int YSTART = SCALAR;
	public static int numPlayers = 0;
	
	public static boolean gameOver = false;
	public static boolean hasRolled = false; //flag to register when the Start! button has been pressed. Recycled to flag if the dice have been rolled this turn
	public static boolean hasPressedBuild = false;
	
	public static DevCards devDeck = new DevCards();
	
	public static JButton startGame = new JButton("Start Game");
	public static JButton reshuffleBoard = new JButton("Reshuffle Board");
	public static JButton rollDice = new JButton();
	public static JButton buildMenu = new JButton("Build (B)");
	public static JFrame window = new JFrame("Stags of Catan");
	public static RandomGenerator dice = new RandomGenerator(6,6);
	public static TurnTracker turns = new TurnTracker();
	
	public static KeyboardReader keyboardInput = new KeyboardReader();
	public static BuildPanel buildPanel = new BuildPanel(SCALAR);
	
	/**
	 * JLabels control the text that indicates the player names and hand sizes
	 */
	public static JLabel player1Name = new JLabel("");
	public static JLabel player2Name = new JLabel("");
	public static JLabel player3Name = new JLabel("");
	public static JLabel player4Name = new JLabel("");
	//JPanel that holds the JLabels and sets the location on the screen
	public static JPanel playerPanel = new JPanel();

	/**
	 * These players are used to keep track of turns and people
	 * All 4 are generated even if only 2 players are in the game
	 */
	public static Player player1 = new Player(1);
	public static Player player2 = new Player(2);
	public static Player player3 = new Player(3);
	public static Player player4 = new Player(4);
	
	private static final BoardData boardData = new BoardData();


	/**
	 * Main Method that controls the game
	 * @param args
	 */
	public static void main(String[] args) {
		turns.addPlayer(player1);
		window.add(new BoardDisplay());
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setExtendedState(Frame.MAXIMIZED_BOTH);
		window.setLocationRelativeTo(null);
		//window.setBackground(new Color(114, 162,254));<- save for later
		window.setVisible(true);
		window.setLayout(null); //Necessary to be able to set the direct x and y coordinates
		reshuffleBoardButton();
		setPlayerNames();
		startGame(player1, player2, player3, player4);
		window.addKeyListener(keyboardInput);
		player1.giveBrick(1);
		player1.giveWheat(2);
		player1.giveSheep(1);
		player1.giveWood(1);
		player1.giveOre(3);
		player2.giveBrick(1);
		player2.giveWheat(2);
		player2.giveSheep(1);
		player2.giveWood(1);
		player2.giveOre(3);
		player3.giveBrick(1);
		player3.giveWheat(2);
		player3.giveSheep(1);
		player3.giveWood(1);
		player3.giveOre(3);
		player4.giveBrick(1);
		player4.giveWheat(2);
		player4.giveSheep(1);
		player4.giveWood(1);
		player4.giveOre(3);
		updatePlayerPanel();
		while(!gameOver) {
			window.requestFocusInWindow();
			checkPlayerInput();
			if(getCurrentPlayer().getBuilding() != 0) {
				//Add building functionality here
			}
		}
	}

	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(XDIM, YDIM);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		this.update(g);
	}
	
	public static Player getCurrentPlayer() {
		if(turns.getPlayerTurn() == 1) {
			return player1;
		}
		if(turns.getPlayerTurn() == 2) {
			return player2;
		}
		if(turns.getPlayerTurn() == 3) {
			return player3;
		}
		else{
			return player4;
		}
	}
	
	
	@Override
	public void update(Graphics g) {
		// print all tiles
		for(int i = 0; i < boardData.getTiles().length; i++) {
			boardData.getTileAt(i).drawTile(g);
		}
		
		turns.returnCurrentPlayer().displayHand(g);
		
		for(int i = 0; i < boardData.getPlayers().length; i++) {
			boardData.getPlayers()[i].drawAll(g);
		}
		
		// road test
		/*Vertex v1 = new Vertex(XSTART, YSTART, 0, 0);
		Vertex v2 = new Vertex(XSTART+3*SCALAR, YSTART+2*SCALAR, 0, 0);
		Vertex v3 = new Vertex(XSTART-3*SCALAR, YSTART+2*SCALAR, 0, 0);
		Vertex v4 = new Vertex(XSTART+3*SCALAR, YSTART+5*SCALAR, 0, 0);
		Road r1 = new Road(v1, v2, player1.getColor());
		Road r2 = new Road(v1, v3, player2.getColor());
		Road r3 = new Road(v2, v4, player3.getColor());
		r1.draw(g);
		r2.draw(g);
		r3.draw(g);
		
		// settlement test
		Settlement s1 = new Settlement(XSTART, YSTART, player1);
		s1.draw(g);
		
		// city test
		City c1 = new City(XSTART + 3*SCALAR, YSTART + 2*SCALAR, player2);
		c1.draw(g);
		*/
		
		// test vertexes
		boardData.getVertexArray().test(g);
	}
	
	/**
	 * Sets the location of the buttons, and then codes actions when the buttons are pressed
	 * @param reshuffleBoard
	 * @param startGame
	 */
	public static void reshuffleBoardButton() {
		reshuffleBoard.setBounds(44 * SCALAR, 23 * SCALAR, 7 * SCALAR, 3*SCALAR);
		startGame.setBounds(44 * SCALAR, 27 * SCALAR, 7 * SCALAR, 3*SCALAR);
		reshuffleClass resetHandler = new reshuffleClass();
		startGameClass startHandler = new startGameClass();
		reshuffleBoard.addActionListener(resetHandler);
		startGame.addActionListener(startHandler);
		window.add(reshuffleBoard);
		window.add(startGame);
		reshuffleBoard.setVisible(true);
		startGame.setVisible(true);
	}
	
	/**
	 * When the reset board button is pressed, reshuffle the tiles and numbers, then redraw the board
	 * @author andro
	 *
	 */
	private static class reshuffleClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			boardData.shuffleTiles();
			boardData.setLocations();
			boardData.shuffleNumbers();
			window.repaint();
		}
	}
	
	/**
	 * Handles the start game button by setting the hasRolled flag to true
	 * @author andro
	 *
	 */
	private static class startGameClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			hasRolled = true;
		}
	}
	
	/**
	 * Handles the end turn / roll dice button
	 * @author andro
	 *
	 */
	private static class rollDiceHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(hasRolled == true) {
				turns.cycleTurn();
				buildMenu.setVisible(false);
				rollDice.setText("Roll Dice (R)");
				window.repaint();
				hasRolled = false;
				JOptionPane.showMessageDialog(window, String.format("%s", turns.returnCurrentPlayer().getName() + "'s Turn"));
			}
			else if(hasRolled == false) {
				rollDice.setText("End Turn (D)");
				buildMenu.setVisible(true);
				window.repaint();
				hasRolled = true;
				JOptionPane.showMessageDialog(window, String.format("%s", "Roll: " + dice.getRandom()));
			}
		}
	}
	
	private static class buildMenuHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(hasPressedBuild == false) {
				buildPanel.updatePlayer(getCurrentPlayer());
				buildMenu.setText("Undo");
				buildPanel.setFocusable(false);
				buildPanel.setVisible(true);
				hasPressedBuild = true;
			}
			else {
				buildMenu.setText("Build (B)");
				if(getCurrentPlayer().getBuilding() == 1) {
					getCurrentPlayer().giveBrick(1);
					getCurrentPlayer().giveWood(1);
				}
				else if(getCurrentPlayer().getBuilding() == 2) {
					getCurrentPlayer().giveBrick(1);
					getCurrentPlayer().giveWood(1);
					getCurrentPlayer().giveSheep(1);
					getCurrentPlayer().giveWheat(1);
				}
				else if(getCurrentPlayer().getBuilding() == 3) {
					getCurrentPlayer().giveWheat(2);
					getCurrentPlayer().giveOre(3);
				}
				getCurrentPlayer().setBuilding(0);
				updatePlayerPanel();
				buildPanel.setVisible(false);
				hasPressedBuild = false;
			}
		}
	}
	
	
	public static void startGame(Player player1, Player player2, Player player3, Player player4) {
		hasRolled = false;
		rollDice.setText("Roll Dice (R)");
		window.remove(startGame);
		window.remove(reshuffleBoard);
		window.add(rollDice);
		window.add(buildMenu);
		buildMenu.setVisible(false); //Initially invisible until Roll Dice Button is pressed
		rollDice.setBounds(44 * SCALAR, 27 * SCALAR, 7 * SCALAR, 3*SCALAR); //Sets the size and location of the button. (x, y, xdim, ydim)
		rollDiceHandler rollHandler = new rollDiceHandler();
		rollDice.addActionListener(rollHandler);
		buildMenu.setBounds(44 * SCALAR, 23 * SCALAR, 7 * SCALAR, 3*SCALAR); //Sets the size and location of the button. (x, y, xdim, ydim)
		buildMenuHandler buildHandler = new buildMenuHandler();
		buildMenu.addActionListener(buildHandler);
		turns.addPlayer(player2);
		if(numPlayers > 2) {
			turns.addPlayer(player3);
		}
		if(numPlayers > 3) {
			turns.addPlayer(player4);
		}
		window.repaint();
	}
	
	/**
	 * Updates the player panel using the current names and hand totals
	 */
	public static void updatePlayerPanel() {
		player1Name.setText(player1.getName() + ": Hand Size = " + player1.getTotal() + " Dev Cards = " + player1.numDevCards());
		player2Name.setText(player2.getName() + ": Hand Size = " + player2.getTotal() + " Dev Cards = " + player2.numDevCards());
		player3Name.setText(player3.getName() + ": Hand Size = " + player3.getTotal() + " Dev Cards = " + player3.numDevCards());
		player4Name.setText(player4.getName() + ": Hand Size = " + player4.getTotal() + " Dev Cards = " + player4.numDevCards());
		window.repaint();
	}
		
	
	/**
	 * Adds the panel and labels to the screen, and takes in user input to set the names of the players
	 */
	public static void setPlayerNames() {
		window.add(playerPanel);
		//The game requires two players at least, so initialize the player panel with 2 players
		playerPanel.add(player1Name);	
		playerPanel.add(player2Name);
		//Wait until the player clicks on start game
		while(hasRolled == false) {
			try { Thread.sleep(200); } catch (InterruptedException e) {};
		}
		
		InputTextBox startingText = new InputTextBox(SCALAR); //Creates a text box read the number of players
		/**
		 * Calls the generatePlayerName function for each player, and updates the associated JLabel
		 */
		player1.setName(startingText.generatePlayerName(1));		
		player1Name.setText(player1.getName() + ": Hand Size = " + player1.getTotal() + " Dev Cards = " + player1.numDevCards());
		player2.setName(startingText.generatePlayerName(2));		
		player2Name.setText(player2.getName() + ": Hand Size = " + player2.getTotal() + " Dev Cards = " + player2.numDevCards());
		int panelDims = (Math.max( player1Name.getWidth() +player1Name.getText().length(), player2Name.getWidth() +player2Name.getText().length()));
		if(startingText.getNumPlayers() > 2) {
			playerPanel.add(player3Name);
			player3.setName(startingText.generatePlayerName(3)); 	
			player3Name.setText(player3.getName() + ": Hand Size = " + player3.getTotal() + " Dev Cards = " + player3.numDevCards());
			panelDims = (Math.max(panelDims, player3Name.getWidth() +player3Name.getText().length()));
		}
		if(startingText.getNumPlayers() > 3) {
			playerPanel.add(player4Name);
			player4.setName(startingText.generatePlayerName(4));	
			player4Name.setText(player4.getName() + ": Hand Size = " + player4.getTotal() + " Dev Cards = " + player4.numDevCards());
			panelDims = (Math.max(panelDims, player4Name.getWidth() + player4Name.getText().length()));
		}
		numPlayers = startingText.getNumPlayers();	
		playerPanel.setSize(panelDims + SCALAR, 10 * SCALAR);
		playerPanel.setLocation(48*SCALAR - panelDims, 10*SCALAR);
		playerPanel.setVisible(true);					
		window.repaint();
		
	}
	
	private static void checkPlayerInput() {
		//Handle build hotkey input
		if(keyboardInput.buildIsPressed()) {
			if(buildMenu.isVisible()) {
				buildMenu.doClick();
			}
		}
		//Handle end turn hotkey input
		if(keyboardInput.endTurnIsPressed()) {
			if(hasRolled) {
				rollDice.doClick();
			}
		}
		//Handle roll dice hotkey input
		if(keyboardInput.rollDiceIsPressed()) {
			if(!hasRolled) {
				rollDice.doClick();
			}
		}
	}
	

}
