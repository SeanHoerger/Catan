package catan;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class House {
	private Vertex vertex;
	private boolean visible;
	
	public House() {
		vertex = new Vertex();
		visible = false;
	}
	
	public House(Vertex v) {
		vertex = v;
		visible = true;
	}
	
	public Vertex getVertex() {
		return vertex;
	}
	
	public int getX() {
		return vertex.getX();
	}
	
	public int getY() {
		return vertex.getY();
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public abstract void draw(Graphics g, Color c);
}
