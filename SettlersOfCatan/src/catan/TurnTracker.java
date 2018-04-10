package catan;

import java.awt.event.*;
import javax.swing.*;

/**
 * This class needs the following arguments at the minimum:
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
	private int playerTurn = 1; //Int that ranges from 1 - the number of players and keeps track of the turns
	private int numPlayers;		//The number of players, starting at 1
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private int SCALAR;
	/**
	 * Constructor
	 * Players are added through the method, not initialized
	 */

	public TurnTracker() { //Generic constructor
		this.numPlayers = 0;
	}
	
	/**
	 * Getters for player turn
	 */
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	public Player returnCurrentPlayer() {
		if(playerTurn == 1) {
			return player1;
		}
		else if(playerTurn == 2) {
			return player2;
		}
		else if(playerTurn == 3) {
			return player3;
		}
		else{
			return player4;
		}
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

	}
	
	/**
	 * This class controls the functionality of the button
	 *
	 */
	private class HandlerClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			cycleTurn();
		}
	}
	
	/**
	 * Function to allow the addition of players
	 * Used in the generic constructor form
	 * @param player
	 */
	public void addPlayer(Player player) {
		if(this.numPlayers < 4) {
			if(this.numPlayers == 0) {
				this.player1 = player;
			}
			else if(this.numPlayers == 1) {
				this.player2 = player;
			}
			else if(this.numPlayers == 2) {
				this.player3 = player;
			}
			else if(this.numPlayers == 3) {
				this.player4 = player;
			}
			this.numPlayers++;
		}
	}
	
	
}
