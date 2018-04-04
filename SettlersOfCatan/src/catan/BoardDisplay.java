package catan;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

// This class is where the visuals are displayed. It also contains the main method.

public class BoardDisplay extends JComponent {

	public static boolean hasRolled = false; //flag to register when the Start! button has been pressed. Recycled to flag if the dice have been rolled this turn
	public static final int XDIM = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int YDIM = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static final int SCALAR = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 55); // <-- magic number: 55
	public static final int XSTART = 10*SCALAR;
	public static final int YSTART = (int)(1.5*SCALAR);
	public static int numPlayers = 0;
	public static JButton startGame = new JButton("Start Game");
	public static JButton reshuffleBoard = new JButton("Reshuffle Board");
	public static JButton rollDice = new JButton();
	public static JFrame window = new JFrame("Stags of Catan");
	public static RandomGenerator dice = new RandomGenerator(6,6);
	public static TurnTracker turns = new TurnTracker();
	public static JButton buildMenu = new JButton("Build (B)");
	
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

	public static void main(String[] args) {
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
	}

	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(XDIM, YDIM);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		this.update(g);
	}
	
	
	@Override
	public void update(Graphics g) {
		// print all tiles
		for(int i = 0; i < boardData.getTiles().length; i++) {
			boardData.getTileAt(i).drawTile(g);
		}
		
		// card test
		Hand testHand = new Hand(8,0,2,3,12);
		Player testPlayer = new Player(1, testHand);
		testPlayer.displayHand(g);
		
		// road test
		Road r1 = new Road(XSTART, YSTART, XSTART+3*SCALAR, YSTART+2*SCALAR, Color.RED);
		Road r2 = new Road(XSTART, YSTART, XSTART-3*SCALAR, YSTART+2*SCALAR, Color.ORANGE);
		Road r3 = new Road(XSTART+3*SCALAR, YSTART+2*SCALAR, XSTART+3*SCALAR, YSTART+5*SCALAR, Color.BLUE);
		r1.draw(g);
		r2.draw(g);
		r3.draw(g);
		
		// settlement test
		Settlement s1 = new Settlement(XSTART, YSTART, Color.RED);
		s1.draw(g);
		
		// city test
		City c1 = new City(XSTART + 3*SCALAR, YSTART + 2*SCALAR, Color.WHITE);
		c1.draw(g);
		
	}
	
	/**
	 * Sets the location of the buttons, and then codes actions when the buttons are pressed
	 * @param reshuffleBoard
	 * @param startGame
	 */
	public static void reshuffleBoardButton() {
		reshuffleBoard.setBounds(40 * SCALAR, 3 * SCALAR, 7 * SCALAR, 3 * SCALAR);
		startGame.setSize(7*SCALAR, 3*SCALAR);
		startGame.setLocation(40*SCALAR, 6 * SCALAR);
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
				rollDice.setText("Roll Dice");
				window.repaint();
				hasRolled = false;
				JOptionPane.showMessageDialog(window, String.format("%s", returnCurrentPlayer() + "'s Turn"));
			}
			else if(hasRolled == false) {
				rollDice.setText("End Turn");
				window.repaint();
				hasRolled = true;
				JOptionPane.showMessageDialog(window, String.format("%s", "Roll: " + dice.getRandom()));
			}
		}
	}
	
	private static class buildMenuHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			BuildPanel buildPanel = new BuildPanel(SCALAR);
		}
	}
	
	
	public static void startGame(Player player1, Player player2, Player player3, Player player4) {
		hasRolled = false;
		rollDice.setText("Roll Dice");
		window.remove(startGame);
		window.remove(reshuffleBoard);
		window.add(rollDice);
		window.add(buildMenu);
		rollDice.setBounds(40 * SCALAR, 25 * SCALAR, 7 * SCALAR, 3 * SCALAR); //Sets the size and location of the button. (x, y, xdim, ydim)
		rollDiceHandler rollHandler = new rollDiceHandler();
		rollDice.addActionListener(rollHandler);
		buildMenu.setBounds(40 * SCALAR, 20 * SCALAR, 7 * SCALAR, 3 * SCALAR); //Sets the size and location of the button. (x, y, xdim, ydim)
		buildMenuHandler buildHandler = new buildMenuHandler();
		buildMenu.addActionListener(buildHandler);
		turns.addPlayer(player1);
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
		player1Name.setText(player1.getName() + ": Hand Size = " + player1.getTotal());
		player2Name.setText(player2.getName() + ": Hand Size = " + player2.getTotal());
		player3Name.setText(player3.getName() + ": Hand Size = " + player3.getTotal());
		player4Name.setText(player4.getName() + ": Hand Size = " + player4.getTotal());
		window.repaint();
	}
	
	public static String returnCurrentPlayer() {
		if(turns.getPlayerTurn() == 1) {
			return player1.getName();
		}
		if(turns.getPlayerTurn() == 2) {
			return player2.getName();
		}
		if(turns.getPlayerTurn() == 3) {
			return player3.getName();
		}
		else{
			return player4.getName();
		}
	}
	
	
	/**
	 * Adds the panel and labels to the screen, and takes in user input to set the names of the players
	 */
	public static void setPlayerNames() {
		window.add(playerPanel);
		playerPanel.add(player1Name);
		playerPanel.add(player2Name);
		while(hasRolled == false) {
			try { Thread.sleep(200); } catch (InterruptedException e) {};
		}
		InputTextBox startingText = new InputTextBox(SCALAR); //Creates a text box read the number of players
		/**
		 * Calls the generatePlayerName function for each player, and updates the associated JLabel
		 */
		player1.setName(startingText.generatePlayerName(1));
		player1Name.setText(player1.getName() + ": Hand Size = " + player1.getTotal());
		player2.setName(startingText.generatePlayerName(2));
		player2Name.setText(player2.getName() + ": Hand Size = " + player2.getTotal());
		int panelDims = (Math.max(player1Name.getWidth(), player2Name.getWidth()));
		playerPanel.setLocation(40*SCALAR, 3*SCALAR);
		if(startingText.getNumPlayers() > 2) {
			playerPanel.add(player3Name);
			player3.setName(startingText.generatePlayerName(3));
			player3Name.setText(player3.getName() + ": Hand Size = " + player3.getTotal());
			panelDims = (Math.max(panelDims, player3Name.getWidth()));
		}
		if(startingText.getNumPlayers() > 3) {
			playerPanel.add(player4Name);
			player4.setName(startingText.generatePlayerName(4));
			player4Name.setText(player4.getName() + ": Hand Size = " + player4.getTotal());
			panelDims = (Math.max(panelDims, player4Name.getWidth()));
		}
		numPlayers = startingText.getNumPlayers();
		playerPanel.setSize(panelDims + SCALAR, 10 * SCALAR);
		playerPanel.setVisible(true);
		window.repaint();
	}
	
}
