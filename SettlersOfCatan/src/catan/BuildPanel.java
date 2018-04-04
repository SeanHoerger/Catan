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
		holder.add(buildRoad);
		holder.add(buildSettlement);
		holder.add(buildCity);
		holder.add(buildDevCard);
		add(holder);
	}
	
	public void initializeButtons() {
		buildRoad.setBounds(SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		buildSettlement.setBounds(8*SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		buildCity.setBounds(15*SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		buildDevCard.setBounds(22*SCALAR, 8*SCALAR, 6*SCALAR, 3*SCALAR);
		
		//Road image
		Icon road = new ImageIcon(getClass().getResource("Road.png"));
		Icon no = new ImageIcon(getClass().getResource("No_Sign.png"));
		if(currentPlayer.getBrick() > 0 && currentPlayer.getWood() > 0) {
			buildRoad.setIcon(road);
		}
		else{
			buildRoad.setIcon(no);
		}
		
		//TODO: Settlement image
		if(currentPlayer.getBrick() > 0 && currentPlayer.getWood() > 0
				&& currentPlayer.getWheat() > 0 && currentPlayer.getSheep() > 0) {
			
		}
		else {
			buildSettlement.setIcon(no);
		}
		
		//TODO: City image
		if(currentPlayer.getWheat() > 1 && currentPlayer.getOre() > 2) {
			
		}
		else {
			buildCity.setIcon(no);
		}
		
		//TODO: Dev Card Image
		if(currentPlayer.getWheat() > 0 && currentPlayer.getSheep() > 0 && currentPlayer.getOre() > 0) {
			
		}
		else {
			buildDevCard.setIcon(no);
		}
	}

}
