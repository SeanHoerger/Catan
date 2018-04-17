package catan;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Vertex extends Location {
	/**
	 * Grant wrote this so.... yeah
	 */
	private int houseType; // 0 = unsettled, 1 = settlement, 2 = city
	public static JButton vertexButton = new JButton();
	private boolean flag = false; //Flag to determine if the vertex was clicked
	ArrayList<Tile> neighborTiles;
	
	//constructor for Vertices
	public Vertex(int x, int y, int houseType) { 
		super(x,y);
		this.houseType = houseType;
		vertexButton.setBounds(getX()-BoardDisplay.SCALAR/2, getY()-BoardDisplay.SCALAR/2, 
				BoardDisplay.SCALAR, BoardDisplay.SCALAR);
		vertexHandler vertexFunction = new vertexHandler();
		vertexButton.addActionListener(vertexFunction);
		neighborTiles = new ArrayList<Tile>();
	}
	
	public Vertex() {
		super(0,0);
		houseType = 0;
		
		vertexButton.setBounds(getX()-BoardDisplay.SCALAR/2, getY()-BoardDisplay.SCALAR/2, 
				BoardDisplay.SCALAR, BoardDisplay.SCALAR);
		vertexHandler vertexFunction = new vertexHandler();
		vertexButton.addActionListener(vertexFunction);
		neighborTiles = new ArrayList<Tile>();
	}
	
	
	// getters and settlers
	// The parent class already contains a getX() and getY() function
	public int getHouseType() {
		return houseType;
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
	
	public void addNeighbor(Tile neighbor) {
		neighborTiles.add(neighbor);
	}
	
	public boolean equals(Vertex v) {
		if(this.getX() == v.getX() && this.getY() == v.getY()) {
			return true;
		}
		return false;
	}

	private class vertexHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent Event) {
			//Functionality
			flag = true;
		}
	}
	
}
