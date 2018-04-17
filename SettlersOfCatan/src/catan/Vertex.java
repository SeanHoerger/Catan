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
	private boolean flag = false; //Flag to determine if the vertex was clicked
	
	//constructor for Vertices
	public Vertex(int x, int y, int number, int houseType) { 
		super(x,y);
		this.number = number;
		this.houseType = houseType;
		vertexButton.setBounds(getX()-BoardDisplay.SCALAR/2, getY()-BoardDisplay.SCALAR/2, 
				BoardDisplay.SCALAR, BoardDisplay.SCALAR);
		vertexHandler vertexFunction = new vertexHandler();
		vertexButton.addActionListener(vertexFunction);
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
	
	public boolean isClicked() {
		return flag;
	}
	
	public void resetClicked() {
		flag = false;
	}

	private class vertexHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent Event) {
			//Functionality
			flag = true;
		}
	}
	
}
