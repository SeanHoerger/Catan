package catan;

import java.awt.Color;
import java.awt.Graphics;

public abstract class House {
	private int x;
	private int y;
	private Color color;
	
	public House(int x, int y, Color playerColor) {
		this.x = x;
		this.y = y;
		color = playerColor;
	}
	
	/*
	public Road(Vertex loc, Color roadColor) {
		this.x = loc.get()X;
		this.y = loc.get()Y;
		color = roadColor;
	}
	*/
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return color;
	}
	
	public abstract void draw(Graphics g);
}
