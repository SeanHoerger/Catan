package catan;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class BuildPanel extends JFrame{
	
	private JFrame window;
	JPanel holder = new JPanel(); // Window to hold the options
	private static JLabel label = new JLabel(); // Holds the instructions
	private static JButton buildRoad = new JButton();
	private static JButton buildSettlement = new JButton();
	private static JButton buildCity = new JButton();
	private static JButton buildDevCard = new JButton();
	private static Player currentPlayer;
	private static int SCALAR;
	private static int flag = 0;
	
	public BuildPanel(int scalar) {
		SCALAR = scalar;
		setTitle("Build Panel"); //Contains the instructions
		setSize(20 * SCALAR, 10 * SCALAR);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(17*SCALAR, 12*SCALAR);
		
		/*
		try { Thread.sleep(200); } catch (InterruptedException e) {}; //Prevents error of the text field not appearing
		setVisible(true);
		while(flag == 0) { //Uses a flag to determine if the user has input a valid response
			try { Thread.sleep(500); } catch (InterruptedException e) {};
		}
		setVisible(false); //Remove the text window and continue the game
		*/
	}

}
