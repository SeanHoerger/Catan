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
		Hand starter = new Hand(0,0,0,0,0);
		Player player1 = new Player(1, starter);
		Player player2 = new Player(2, starter);
		reshuffleBoardButton();
		while(hasRolled == false) {
			try { Thread.sleep(200); } catch (InterruptedException e) {};
		}
		hasRolled = false;
		rollDice.setText("Roll Dice");
		window.remove(startGame);
		window.remove(reshuffleBoard);
		window.add(rollDice);
		startGame(rollDice, player1, player2);
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
		reshuffleBoard.setBounds(40 * SCALAR, 20 * SCALAR, 10 * SCALAR, 4 * SCALAR);
		startGame.setSize(10*SCALAR, 4*SCALAR);
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
				window.remove(rollDice);
				window.add(rollDice);
				window.repaint();
				hasRolled = true;
				JOptionPane.showMessageDialog(window, String.format("%s", "Roll: " + dice.getRandom()));
			}
		}
	}
	
	public static void startGame(JButton rollDice, Player player1, Player player2) {
		rollDice.setBounds(45 * SCALAR, 25 * SCALAR, 4 * SCALAR, 2 * SCALAR); //Sets the size and location of the button. (x, y, xdim, ydim)
		rollDiceHandler rollHandler = new rollDiceHandler();
		rollDice.addActionListener(rollHandler);
		turns.addPlayer(player1);
		turns.addPlayer(player2);
		
	}
	
}
