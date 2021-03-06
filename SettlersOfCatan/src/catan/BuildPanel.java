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
	private static JButton closeWindow = new JButton("Close");
	private static Player currentPlayer;
	private static int SCALAR;
	private static int flag = 0;
	
	public BuildPanel(int scalar) {
		SCALAR = scalar;
		setTitle("Build Panel"); //Contains the instructions
		setSize(21 * SCALAR, 24 * SCALAR);
		setLocation(31*SCALAR, 8*SCALAR);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		holder.setLayout(null);
		label.setBounds(6*SCALAR, 0, 10*SCALAR, SCALAR);
		holder.add(label);
		holder.add(buildRoad);
		holder.add(buildSettlement);
		holder.add(buildCity);
		holder.add(buildDevCard);
		holder.add(closeWindow);
		setFocusable(false);
		add(holder);
	}
	
	public void updatePlayer(Player player) {
		currentPlayer = player;
		initializeButtons();
		initializeButtonIcons();
	}
	/**
	 * Sets the locations of the buttons and edits the images of the buttons depending on the resources
	 * of the current player
	 */
	public void initializeButtons() {
		buildRoad.setBounds(5*SCALAR, 2*SCALAR, 10*SCALAR, 3*SCALAR);
		buildRoad.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		buildSettlement.setBounds(5*SCALAR, 6*SCALAR, 10*SCALAR, 3*SCALAR);
		buildSettlement.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		buildCity.setBounds(5*SCALAR, 10*SCALAR, 10*SCALAR, 3*SCALAR);
		buildCity.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		buildDevCard.setBounds(5*SCALAR, 14*SCALAR, 10*SCALAR, 3*SCALAR);
		buildDevCard.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		closeWindow.setBounds(5*SCALAR, 18*SCALAR, 10*SCALAR, 3*SCALAR);
		closeWindow.setHorizontalAlignment(SwingConstants.HORIZONTAL);
		
		roadHandler roadFunction = new roadHandler();
		buildRoad.addActionListener(roadFunction);
		settlementHandler settlementFunction = new settlementHandler();
		buildSettlement.addActionListener(settlementFunction);
		cityHandler cityFunction = new cityHandler();
		buildCity.addActionListener(cityFunction);
		devHandler devFunction = new devHandler();
		buildDevCard.addActionListener(devFunction);
		closeHandler closeFunction = new closeHandler();
		closeWindow.addActionListener(closeFunction);
		
	}
	
	/**
	 * Update the icons of the buttons
	 */
	public void initializeButtonIcons() {
		//Set Icons based on color
		Icon no = new ImageIcon(getClass().getResource("No_Sign.png"));
		//Player 1 = blue
		Icon road = new ImageIcon(getClass().getResource("RoadBlue.png"));
		Icon settlement = new ImageIcon(getClass().getResource("SettlementBlue.png"));
		Icon city = new ImageIcon(getClass().getResource("CityBlue.png"));
		//Player 2 = white
		if(currentPlayer.getNumber() == 2) {
			road = new ImageIcon(getClass().getResource("RoadWhite.png"));
			settlement = new ImageIcon(getClass().getResource("SettlementWhite.png"));
			city = new ImageIcon(getClass().getResource("CityWhite.png"));
		}
		//Player 3 = orange
		if(currentPlayer.getNumber() == 3) {
			road = new ImageIcon(getClass().getResource("RoadOrange.png"));
			settlement = new ImageIcon(getClass().getResource("SettlementOrange.png"));
			city = new ImageIcon(getClass().getResource("CityOrange.png"));
		}
		//Player 4 = red
		if(currentPlayer.getNumber() == 4){
			road = new ImageIcon(getClass().getResource("RoadRed.png"));
			settlement = new ImageIcon(getClass().getResource("SettlementRed.png"));
			city = new ImageIcon(getClass().getResource("CityRed.png"));
		}
		
		if(currentPlayer.canBuildRoad()) {
			buildRoad.setIcon(road);
		}
		else{
			buildRoad.setIcon(no);
		}
		
		//Set Settlement image
		if(currentPlayer.canBuildSettlement()) {
			buildSettlement.setIcon(settlement);
		}
		else {
			buildSettlement.setIcon(no);
		}
		
		//Set City image
		if(currentPlayer.canBuildCity()) {
			buildCity.setIcon(city);
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
				currentPlayer.setBuilding(1);
				BoardDisplay.updatePlayerPanel();
				setVisible(false);
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
				currentPlayer.setBuilding(2);
				BoardDisplay.updatePlayerPanel();
				setVisible(false);
			}
		}
	}
	
	private class cityHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			if(currentPlayer.canBuildCity()) {
				currentPlayer.giveWheat(-2);
				currentPlayer.giveOre(-3);
				currentPlayer.setBuilding(3);
				BoardDisplay.updatePlayerPanel();
				setVisible(false);
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
				currentPlayer.giveDevCard(BoardDisplay.devDeck.drawDev());
				BoardDisplay.updatePlayerPanel();
				setVisible(false);
			}
		}
	}
	
	private class closeHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			currentPlayer.setBuilding(0);
			BoardDisplay.buildPanel.setVisible(false);
			BoardDisplay.hasPressedBuild = false;
			BoardDisplay.buildMenu.setText("Build (B)");
		}
	}

}
