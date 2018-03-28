package catan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Road {
	
	//private Vertex start; // starting point
	//private Vertex end; // end point
	private Location start; // temporary cause vertexes don't exist yet
	private Location end; // temporary cause vertexes don't exist yet
	private Color color;
	
	public Road() {
		start = new Location();
		end = new Location();
		color = Color.black;
	}
	
	public Road(int startX, int startY, int endX, int endY, Color roadColor) {
		start = new Location(startX, startY);
		end = new Location(endX, endY);
		color = roadColor;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
        g2.setStroke(new BasicStroke(15.0f, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND));
		g2.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
		g2.setColor(Color.BLACK);
		float[] dash1 = {10.0f};
		g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 10.0f, dash1, 0.0f));
		g2.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
	}
	
}
