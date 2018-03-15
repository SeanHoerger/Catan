package catan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InitialInputTextBox extends JFrame {

	/**
	 * Produces a text box to read input and determine the number of players
	 */
	JPanel holder = new JPanel();//Holder to contain the text field
	private static JLabel label = new JLabel();
	private static JTextField inputField = new JTextField(35);
	private static int numPlayers;
	private static int flag = 0;
	
	public InitialInputTextBox(int SCALAR) 
	{
		setTitle("Please enter the number of players:"); //Contains the instructions
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(17*SCALAR, 12*SCALAR);
		readInput reader = new readInput();
		inputField.addActionListener(reader);
		holder.add(inputField);
		holder.add(label);
		add(holder);
		while(flag == 0) { //Uses a flag to determine if the user has input a valid response
			try { Thread.sleep(200); } catch (InterruptedException e) {};
		}
		setVisible(false); //Remove the text window and continue the game
		remove(holder);
	}
	
	/*public static void main(String[] args) {
		InitialInputTextBox t = new InitialInputTextBox();
	}*/

	public int getNumPlayers() {
		return numPlayers;
	}
	
	/**
	 * Checks for valid inputs and returns an error message if the input is not either a 2, 3 or 4
	 * @author andro
	 *
	 */
	private static class readInput implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String input = inputField.getText();
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
	}
	
	
}
