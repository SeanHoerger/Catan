package catan;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

/*
 * Opens a build panel menu for the player to select what they want to build
 */
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
	
	public BuildPanel(int scalar, Player player) {
		SCALAR = scalar;
		currentPlayer = player;
		setTitle("Build Panel"); //Contains the instructions
		setSize(30 * SCALAR, 15 * SCALAR);
		setLocation(13*SCALAR, 8*SCALAR);
		holder.setLayout(null);
		label.setBounds(11*SCALAR, SCALAR, 10*SCALAR, SCALAR);
		holder.add(label);
		initializeButtons();
		initializeButtonIcons();
		holder.add(buildRoad);
		holder.add(buildSettlement);
		holder.add(buildCity);
		holder.add(buildDevCard);
		add(holder);
	}
	
	/**
	 * Sets the locations of the buttons and edits the images of the buttons depending on the resources
	 * of the current player
	 */
	public void initializeButtons() {
		buildRoad.setBounds(SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		buildSettlement.setBounds(8*SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		buildCity.setBounds(15*SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		buildDevCard.setBounds(22*SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		
		roadHandler roadFunction = new roadHandler();
		buildRoad.addActionListener(roadFunction);
		settlementHandler settlementFunction = new settlementHandler();
		buildSettlement.addActionListener(settlementFunction);
		cityHandler cityFunction = new cityHandler();
		buildCity.addActionListener(cityFunction);
		devHandler devFunction = new devHandler();
		buildDevCard.addActionListener(devFunction);
		
	}
	
	/**
	 * Update the icons of the buttons
	 */
	public void initializeButtonIcons() {
		//Road image
		Icon road = new ImageIcon(getClass().getResource("Road.png"));
		Icon no = new ImageIcon(getClass().getResource("No_Sign.png"));
		if(currentPlayer.canBuildRoad()) {
			buildRoad.setIcon(road);
		}
		else{
			buildRoad.setIcon(no);
		}
		
		//TODO: Settlement image
		if(currentPlayer.canBuildSettlement()) {
			
		}
		else {
			buildSettlement.setIcon(no);
		}
		
		//TODO: City image
		if(currentPlayer.canBuildCity()) {
			
		}
		else {
			buildCity.setIcon(no);
		}
		
		//TODO: Dev Card Image
		if(currentPlayer.canBuildDevCard()) {
			
		}
		else {
			buildDevCard.setIcon(no);
		}
	}
	
	/**
	 * Button methods
	 */
	
	private class roadHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(currentPlayer.canBuildRoad()) {
				currentPlayer.giveWood(-1);
				currentPlayer.giveBrick(-1);
				dispose();
			}
		}
	}
	
	private class settlementHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(currentPlayer.canBuildSettlement()) {
				currentPlayer.giveWood(-1);
				currentPlayer.giveBrick(-1);
				currentPlayer.giveWheat(-1);
				currentPlayer.giveSheep(-1);
				dispose();
			}
		}
	}
	
	private class cityHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(currentPlayer.canBuildCity()) {
				currentPlayer.giveWheat(-2);
				currentPlayer.giveOre(-3);
				dispose();
			}
		}
	}
	
	private class devHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(currentPlayer.canBuildDevCard()) {
				currentPlayer.giveWheat(-1);
				currentPlayer.giveSheep(-1);
				currentPlayer.giveOre(-1);
				dispose();
			}
		}
	}

}
