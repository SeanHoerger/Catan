package catan;

import javax.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class needs the following arguments at the minimum:
 * 		JFrame window  		- Where the button will pop up
 * 		int SCALAR			- Parameters for the button
 * 		Player one
 * 		Player two
 * 
 * Function: Keep track of the turns and provide and end turn button on the board
 * 
 * @author andro
 *
 */
public class TurnTracker {
	private JFrame window;		//Which window the button will show up in
	private JButton endTurn;
	private int playerTurn = 1; //Int that ranges from 1 - the number of players and keeps track of the turns
	private int numPlayers;		//The number of players, starting at 1
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private int SCALAR;
	/**
	 * Constructor
	 * Assumes player1 is the starting player
	 * Only 3 constructors since you cannot play the game with only 1 player
	 * (Note: This will need to change if we implement AI)
	 */
	public TurnTracker(JFrame hostWindow, int SCALAR, Player one, Player two, Player three, Player four) {
		this.window = hostWindow;
		this.SCALAR = SCALAR;
		this.player1 = one;
		this.player2 = two;
		this.player3 = three;
		this.player4 = four;
		this.numPlayers = 4;
		//this.addEndTurnButton();
	}
	
	public TurnTracker(JFrame hostWindow, int SCALAR, Player one, Player two, Player three) {
		this.window = hostWindow;
		this.SCALAR = SCALAR;
		this.player1 = one;
		this.player2 = two;
		this.player3 = three;
		this.numPlayers = 3;
		//this.addEndTurnButton();
	}
	
	public TurnTracker(JFrame hostWindow, int SCALAR, Player one, Player two) {
		this.window = hostWindow;
		this.SCALAR = SCALAR;
		this.player1 = one;
		this.player2 = two;
		this.numPlayers = 2;
		//this.addEndTurnButton();
	}
	
	/**
	 * Getters for player turn
	 */
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	/**
	 * Function to cycle the player turns
	 */
	public void cycleTurn() {
		if(playerTurn < numPlayers) {
			playerTurn++;
		}
		else {
			playerTurn = 1;
		}
	}
	
	/**
	 * Add the button
	 */
	public void addEndTurnButton() {
		JButton endTurn = new JButton("End Turn");
		endTurn.setBounds(45 * SCALAR, 25 * SCALAR, 150, 40);
		endTurn.setSize(20, 40);
		HandlerClass handler = new HandlerClass();
		endTurn.addActionListener(handler);
		//window.add(endTurn);

	}
	
	/**
	 * This class controls the functionality of the button
	 *
	 */
	private class HandlerClass implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			cycleTurn();
			JOptionPane.showMessageDialog(window, String.format("%s", "PlayerTurn: " + playerTurn));
		}
	}
	
	
	
}
