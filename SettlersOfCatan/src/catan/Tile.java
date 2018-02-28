package catan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

// this class represents a tile on the board

public class Tile {

	/**Location of the tile on the board
	 * stores the location object for the tile
	 */
	private Location location;
	
	/**Int representing which resource the tile gives when rolled
	 * 0 == wood; 1 == brick; 2 == wheat; 3 == sheep; 4 == ore, 5 == desert
	 */
	private int tileType;
	
	// stores color of the tile
	private Color color;
	
	/**The number on the tile */
	private int number;
	
	/**false == noRobber, true == hasRobber */
	private boolean hasRobber = false;
	
	/**
	 * Constructors
	 */
	public Tile (Location location, int inputTileType, int inputNumber, boolean inputHasRobber, Color inputColor) {
		this.location = location;
		this.tileType = inputTileType;
		this.number = inputNumber;
		this.hasRobber = inputHasRobber;
		this.color = inputColor;
		
	}
	
	public Tile() {
		this.location = new Location();
		this.tileType = 0;
		this.number = 0;
		this.hasRobber = false;
		this.color = new Color(0,0,0);
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		return "(" + this.getLocation() + " , " + this.getTileType() + " , " + this.getNumber()
		       + " , " + this.hasRobber() + ")";
	}
	
	/**
	 * Getters
	 * access basic information
	 */
	public Location getLocation() {
		return this.location;
	}
	
	public int getX() {
		return this.getLocation().getX();
	}
	
	public int getY() {
		return this.getLocation().getY();
	}
	
	public int getTileType() {
		return this.tileType;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public boolean hasRobber() {
		return this.hasRobber;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Setters
	 * Set basic information
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setTileType(int newType) {
		this.tileType = newType;
	}
	
	public void setNumber(int newNumber) {
		this.number = newNumber;
	}
	
	public void setHasRobber(boolean newRobber) {
		this.hasRobber = newRobber;
	}
	
	public void setColor(Color newColor) {
		this.color = newColor;
	}
	
	// GRAPHICS METHODS:
	
	// method for drawing a hexagon
	private Polygon getHexagon(int x, int y) {
		int[] xValues = {x, x+3*BoardDisplay.SCALAR, x+3*BoardDisplay.SCALAR, 
				x+0*BoardDisplay.SCALAR, x-3*BoardDisplay.SCALAR, x-3*BoardDisplay.SCALAR};
		int[] yValues = {y, y+2*BoardDisplay.SCALAR, y+5*BoardDisplay.SCALAR, 
				y+7*BoardDisplay.SCALAR, y+5*BoardDisplay.SCALAR, y+2*BoardDisplay.SCALAR};
		Polygon hex = new Polygon(xValues, yValues, 6);
		return hex;
	}
	
	// draws the tile and all its attributes
	public void drawTile(Graphics g) {
		int x = this.getX();
		int y = this.getY();
		
		// hexagon
		g.setColor(this.getColor());
		g.fillPolygon(this.getHexagon(x, y));
		g.setColor(Color.BLACK);
		g.drawPolygon(this.getHexagon(x, y));
		
		// circle
		double doubleX = x;
		int newX = (int) (doubleX-1.5*BoardDisplay.SCALAR);
		if(this.hasRobber() == true) {
			g.setColor(new Color(110,110,110));
			g.fillOval(newX, y+2*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR);
			g.setColor(Color.BLACK);
			g.drawOval(newX, y+2*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR);
		}
		else if(this.getTileType() != 5){
			g.setColor(Color.WHITE);
			g.fillOval(newX, y+2*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR);
			g.setColor(Color.BLACK);
			g.drawOval(newX, y+2*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR, 3*BoardDisplay.SCALAR);
		
			// number
			g.setFont(new Font (Font.SANS_SERIF, Font.BOLD, (int)(1.538*BoardDisplay.SCALAR)));
			if(this.getNumber() == 6 || this.getNumber() == 8) {
				g.setColor(Color.RED);
				g.drawString(".....", x- (int) (0.923*BoardDisplay.SCALAR) , y+5*BoardDisplay.SCALAR-(int)(0.654*BoardDisplay.SCALAR));
			}
			else if(this.getNumber() == 5 || this.getNumber() == 9) {
				g.drawString("....", x-(int)(0.731*BoardDisplay.SCALAR), y+5*BoardDisplay.SCALAR-(int)(0.654*BoardDisplay.SCALAR));
			}
			else if(this.getNumber() == 4 || this.getNumber() == 10) {
				g.drawString("...", x-(int)(0.538*BoardDisplay.SCALAR), y+5*BoardDisplay.SCALAR-(int)(0.654*BoardDisplay.SCALAR));
			}
			else if(this.getNumber() == 3 || this.getNumber() == 11) {
				g.drawString("..", x-(int)(0.346*BoardDisplay.SCALAR), y+5*BoardDisplay.SCALAR-(int)(0.654*BoardDisplay.SCALAR));
			}
			else if(this.getNumber() == 2 || this.getNumber() == 12) {
				g.drawString(".", x-(int)(0.154*BoardDisplay.SCALAR), y+5*BoardDisplay.SCALAR-(int)(0.654*BoardDisplay.SCALAR));
			}
			int xAdjust = -(int)(0.462*BoardDisplay.SCALAR);
			int yAdjust = -(int)(1.077*BoardDisplay.SCALAR);
			if(this.getNumber() > 9) {
				xAdjust = 2*xAdjust-(int)(0.077*BoardDisplay.SCALAR);
			}
			g.setFont(new Font (Font.SANS_SERIF, Font.BOLD, (int)(1.538*BoardDisplay.SCALAR)));
			g.drawString("" + this.getNumber(), x + xAdjust, y+5*BoardDisplay.SCALAR + yAdjust);
		}
	}
}
