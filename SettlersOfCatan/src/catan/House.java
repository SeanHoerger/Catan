package catan;

import java.awt.Color;
import java.awt.Graphics;

public abstract class House {
	private int x;
	private int y;
	private Player owner;
	
	public House(int x, int y, Player owner) {
		this.x = x;
		this.y = y;
		this. owner = owner;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public abstract void draw(Graphics g);
}
