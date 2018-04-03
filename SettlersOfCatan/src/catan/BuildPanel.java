package catan;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class BuildPanel extends JFrame{
	
	JPanel holder = new JPanel(); // Window to hold the options
	private static JLabel label = new JLabel("What would you like to build?"); // Holds the instructions
	private static JButton buildRoad = new JButton("Road");
	private static JButton buildSettlement = new JButton("Settlement");
	private static JButton buildCity = new JButton("City");
	private static JButton buildDevCard = new JButton("Dev Card");
	private static Player currentPlayer;
	private static int SCALAR;
	private static int flag = 0;
	
	public BuildPanel(int scalar) {
		SCALAR = scalar;
		setTitle("Build Panel"); //Contains the instructions
		setSize(25 * SCALAR, 15 * SCALAR);
		setLocation(15*SCALAR, 10*SCALAR);
		setLayout(null);
		holder.add(label);
		buildRoad.setBounds(SCALAR, SCALAR, 50*SCALAR, 50*SCALAR);
		holder.add(buildRoad);
		/*
		buildSettlement.setBounds(3*SCALAR, 2*SCALAR, 2*SCALAR, 2*SCALAR);
		holder.add(buildSettlement);
		buildCity.setBounds(6*SCALAR, 2*SCALAR, 2*SCALAR, 2*SCALAR);
		holder.add(buildCity);
		buildDevCard.setBounds(9*SCALAR, 2*SCALAR, 2*SCALAR, 2*SCALAR);
		holder.add(buildDevCard);
		*/
		add(holder);
		/*
		try { Thread.sleep(200); } catch (InterruptedException e) {}; //Prevents error of the text field not appearing
		setVisible(true);
		while(flag == 0) { //Uses a flag to determine if the user has input a valid response
			try { Thread.sleep(500); } catch (InterruptedException e) {};
		}
		setVisible(false); //Remove the text window and continue the game
		*/
	}
	
	public void updateCurrentPlayer(Player player) {
		currentPlayer = player;
	}

}
