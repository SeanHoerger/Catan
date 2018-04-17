package catan;

import java.awt.*;




import java.awt.event.*;
import javax.swing.*;

public class Vertex extends Location {
	/**
	 * Grant wrote this so.... yeah
	 */
	private int number;
	private int houseType; // 0 = unsettled, 1 = settlement, 2 = city
	public static JButton vertexButton = new JButton();
	
	//constructor for Vertices
	public Vertex(int x, int y, int number, int houseType) { 
		super(x,y);
		this.number = number;
		this.houseType = houseType;
		vertexButton.setBounds((x - (int)(0.5*BoardDisplay.SCALAR)), 
				(y - (int)(0.5*BoardDisplay.SCALAR)),
				BoardDisplay.SCALAR, 
				BoardDisplay.SCALAR);
	}
	
	
	// getters and settlers
	// The parent class already contains a getX() and getY() function
	public int getNumber() {
		return number;
	}
	public int getHouseType() {
		return houseType;
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
