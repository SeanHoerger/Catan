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
	public static final int YSTART = SCALAR;
	public static JButton startGame = new JButton("Start Game");
	public static JButton reshuffleBoard = new JButton("Reshuffle Board");
	public static JButton rollDice = new JButton();
	public static JFrame window = new JFrame("Stags of Catan");
	public static RandomGenerator dice = new RandomGenerator(6,6);
	public static TurnTracker turns = new TurnTracker();
	public static JLabel player1Name = new JLabel("");
	public static JLabel player2Name = new JLabel("");
	public static JLabel player3Name = new JLabel("");
	public static JLabel player4Name = new JLabel("");
	public static JPanel playerPanel = new JPanel();

	
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
		window.add(playerPanel);
		playerPanel.add(player1Name);
		playerPanel.add(player2Name);
		Hand starter = new Hand(0,0,0,0,0);
		Player player1 = new Player(1, starter);
		Player player2 = new Player(2, starter);
		Player player3 = new Player(3, starter);
		Player player4 = new Player(4, starter);
		reshuffleBoardButton();
		while(hasRolled == false) {
			try { Thread.sleep(200); } catch (InterruptedException e) {};
		}
		InputTextBox startingText = new InputTextBox(SCALAR); //Creates a text box read the number of players
		player1Name.setText(startingText.generatePlayerName(1) + ": Hand Size = " + player1.getTotal());
		player2Name.setText(startingText.generatePlayerName(2) + ": Hand Size = " + player2.getTotal());
		int panelDims = (Math.max(player1Name.getWidth(), player2Name.getWidth()));
		playerPanel.setLocation(40*SCALAR, 3*SCALAR);
		if(startingText.getNumPlayers() > 2) {
			playerPanel.add(player3Name);
			player3Name.setText(startingText.generatePlayerName(3) + ": Hand Size = " + player3.getTotal());
			panelDims = (Math.max(panelDims, player3Name.getWidth()));
		}
		if(startingText.getNumPlayers() > 3) {
			playerPanel.add(player4Name);
			player4Name.setText(startingText.generatePlayerName(4) + ": Hand Size = " + player4.getTotal());
			panelDims = (Math.max(panelDims, player4Name.getWidth()));
		}
		playerPanel.setSize(panelDims + SCALAR, 10 * SCALAR);
		playerPanel.setVisible(true);
		window.repaint();
		hasRolled = false;
		rollDice.setText("Roll Dice");
		window.remove(startGame);
		window.remove(reshuffleBoard);
		window.add(rollDice);
		startGame(rollDice, startingText.getNumPlayers(), player1, player2, player3, player4);
		window.repaint();
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
		
		//card test
		//Hand testHand = new Hand(8,0,2,3,12);
		//Player testPlayer = new Player(1, testHand);
		//testPlayer.displayHand(g);
	}
	
	/**
	 * Sets the location of the buttons, and then codes actions when the buttons are pressed
	 * @param reshuffleBoard
	 * @param startGame
	 */
	public static void reshuffleBoardButton() {
		reshuffleBoard.setBounds(40 * SCALAR, 20 * SCALAR, 7 * SCALAR, 3 * SCALAR);
		startGame.setSize(7*SCALAR, 3*SCALAR);
		startGame.setLocation(40*SCALAR, 25 * SCALAR);
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
				JOptionPane.showMessageDialog(window, String.format("%s", "Player Turn: " + turns.getPlayerTurn()));
			}
			else if(hasRolled == false) {
				rollDice.setText("End Turn");
				window.repaint();
				hasRolled = true;
				JOptionPane.showMessageDialog(window, String.format("%s", "Roll: " + dice.getRandom()));
			}
		}
	}
	
	public static void startGame(JButton rollDice, int numPlayers, Player player1, Player player2, Player player3, Player player4) {
		rollDice.setBounds(40 * SCALAR, 25 * SCALAR, 7 * SCALAR, 3 * SCALAR); //Sets the size and location of the button. (x, y, xdim, ydim)
		rollDiceHandler rollHandler = new rollDiceHandler();
		rollDice.addActionListener(rollHandler);
		turns.addPlayer(player1);
		turns.addPlayer(player2);
		if(numPlayers > 2) {
			turns.addPlayer(player3);
		}
		if(numPlayers > 3) {
			turns.addPlayer(player4);
		}
		
	}
	
}
