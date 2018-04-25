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
	private JButton vertexButton = new JButton();
	private boolean flag = false; //Flag to determine if the vertex was clicked
	ArrayList<Tile> neighborTiles;
	
	//constructor for Vertices
	public Vertex(int x, int y, int houseType) { 
		super(x,y);
		this.houseType = houseType;
		vertexHandler vertexFunction = new vertexHandler();
		vertexButton.addActionListener(vertexFunction);
		neighborTiles = new ArrayList<Tile>();
		vertexButton.setVisible(true);
	}
	
	public Vertex() {
		super(0,0);
		houseType = 0;
		vertexHandler vertexFunction = new vertexHandler();
		vertexButton.addActionListener(vertexFunction);
		neighborTiles = new ArrayList<Tile>();
		vertexButton.setVisible(true);
	}
	
	
	// getters and settlers
	// The parent class already contains a getX() and getY() function
	public int getHouseType() {
		return houseType;
	}
	
	public ArrayList<Tile> getNeighbors(){
		return neighborTiles;
	}
	
	public void resetNeighbors() {
		neighborTiles = new ArrayList<Tile>();
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

	public JButton getVertexButton() {
		vertexButton.setBounds(getX()-BoardDisplay.SCALAR/2, getY()-BoardDisplay.SCALAR/2, 
				BoardDisplay.SCALAR, BoardDisplay.SCALAR);
		return vertexButton;
	}
	
	public void hideVertexButton() {
		vertexButton.setVisible(false);
	}
	
	public boolean isVisible() {
		if(vertexButton.isVisible()) {
			return true;
		}
		return false;
	}
	
	private class vertexHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent Event) {
			//Functionality
			JFrame window = new JFrame();
			JOptionPane.showMessageDialog(window, "Fuck You");
			flag = true;
		}
	}
	
	public String neighborString() {
		String str = "";
		for (int i = 0; i < neighborTiles.size(); i++) {
			str = str + neighborTiles.get(i).getNumber() + " ";
		}
		return str;
	}
	
	public String toString() {
		return "x: " + super.getX() + ", y: " + super.getY() + ", Neighbors: " + neighborString();
	}
	
}







