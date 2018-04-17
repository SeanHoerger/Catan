package catan;

import java.awt.*;




import java.awt.event.*;
import javax.swing.*;

public class Vertex extends Location {
	/**
	 * Grant wrote this so.... yeah
	 */
	private Player owner;
	private int number;
	private int houseType; // 0 = unsettled, 1 = settlement, 2 = city
	public static JButton vertexButton = new JButton();
	public static final int SCALAR = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 55); // <-- magic number: 55
	
	//constructor for Vertices
	public Vertex(int x, int y, Player owner, int number, int houseType) { 
		super(x,y);
		this.owner = owner;
		this.number = number;
		this.houseType = houseType;
		vertexButton.setBounds(getX(), getY(), SCALAR, SCALAR);
	}
	
	
	// getters and settlers
	// The parent class already contains a getX() and getY() function
	public Player getOwner() {
		return owner;
	}
	public int getNumber() {
		return number;
	}
	public int getHouseType() {
		return houseType;
	}
	public void setOwner(Player owner) {
		this.owner = owner; 
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setHouseType(int houseType) {
		this.houseType = houseType;
	}

	private class vertexHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent Event) {
			//Functionality
		}
	}
	
	
	// 
}
