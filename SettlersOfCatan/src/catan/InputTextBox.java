package catan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputTextBox extends JFrame {

	/**
	 * Produces a text box to read input and determine the number of players
	 * Used in the initiation of the game
	 */
	JPanel holder = new JPanel();//Holder to contain the text field
	private static JLabel label = new JLabel();
	private static JTextField inputField = new JTextField();
	private static int numPlayers;
	private static int flag = 0;
	private static String playerName = "";
	
	public InputTextBox(int SCALAR) 
	{
		inputField.setColumns(3 * SCALAR / 2);
		setTitle("Please enter the number of players:"); //Contains the instructions
		setSize(20 * SCALAR, 10 * SCALAR);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(17*SCALAR, 12*SCALAR);
		readInput reader = new readInput();
		inputField.addActionListener(reader);
		holder.add(inputField);
		holder.add(label);
		add(holder);
		try { Thread.sleep(200); } catch (InterruptedException e) {}; //Prevents error of the text field not appearing
		setVisible(true);
		//TODO: remove the following 2 lines
		numPlayers = 2;
		flag = 1;
		while(flag == 0) { //Uses a flag to determine if the user has input a valid response
			try { Thread.sleep(500); } catch (InterruptedException e) {};
		}
		setVisible(false); //Remove the text window and continue the game
	}
	

	public int getNumPlayers() {
		return numPlayers;
	}
	
	/**
	 * Reads the input and uses the information to set the player's name
	 * @param playerNum
	 * Used to update the title message to indicate which player's name is being entered, otherwise irrelevant
	 * @return
	 */
	public String generatePlayerName(int playerNum) {
		int currentFlag = flag; //Used to indiate if the player name has been entered
		setTitle("Enter the name of player " + playerNum + ": ");
		inputField.setText("");
		label.setText("");
		try { Thread.sleep(200); } catch (InterruptedException e) {};
		setVisible(true);
		while(currentFlag == flag) { //moves on if any input is entered
			try { Thread.sleep(200); } catch (InterruptedException e) {};
		}
		setVisible(false);
		return playerName;
	}
	
	
	/**
	 * Checks for valid inputs and returns an error message if the input is not either a 2, 3 or 4
	 * @author andro
	 *
	 */
	private static class readInput implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String input = inputField.getText();
			if(flag == 0) { //If this is the initial screen indicating the number of players
				if(input.equals("2")) {
					numPlayers = 2;
					flag++;
				}
				else if(input.equals("3")) {
					numPlayers = 3;
					flag++;
				}
				else if(input.equals("4")) {
					numPlayers = 4;
					flag++;
				}
				else {
					label.setText("There can only be 2 - 4 players");
				}
			}
			else { //Else, it is an input determining the name of a player
				playerName = input;
				flag++;
			}
			
		}
	}
	
	
}
