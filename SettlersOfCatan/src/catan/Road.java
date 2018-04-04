package catan;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Road {
	
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color color;
	
	public Road(int startX, int startY, int endX, int endY, Color roadColor) {
		if (startX <= endX) {
			x1 = startX;
			x2 = endX;
			y1 = startY;
			y2 = endY;
		}
		else {
			x1 = endX;
			x2 = startX;
			y1 = endY;
			y2 = startY;
		}
		color = roadColor;
	}
	
	/*
	public Road(Vertex start, Vertex end, Color roadColor) {
		x1 = start.get()X;
		x2 = end.get()X;
		y1 = start.get()Y;
		y2 = endY.get();
		color = roadColor;
	}
	*/
	
	public void draw(Graphics g) {
		
		double xD = x2 - x1;
		double yD = y2 - y1;
		double totalD = Math.sqrt(xD*xD + yD*yD);
		double d = 0.25 * totalD;
		
		double slope;
		int xDelta; 
		int yDelta;
		
		if(xD == 0.0) {
			xDelta = 0;
			yDelta = (int) d;
		}
		else {
			slope = (yD / xD);
			xDelta = (int) (d / Math.sqrt(1 + slope*slope));
			yDelta = (int) (xDelta * slope);
		}
		
		
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(12.0f, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND));
		g2.drawLine(x1+xDelta, y1+yDelta, x2-xDelta, y2-yDelta);
		g2.setColor(color);
		g2.setStroke(new BasicStroke(10.0f, BasicStroke.CAP_BUTT, BasicStroke.CAP_ROUND, 10.0f));
		g2.drawLine(x1+xDelta, y1+yDelta, x2-xDelta, y2-yDelta);
		g2.setStroke(new BasicStroke());
	}
	
}
