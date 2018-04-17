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
	private boolean visible;
	
	public Road() {
		x1 = 0;
		x2 = 0;
		y1 = 0;
		y2 = 0;
		color = Color.BLACK;
		visible = false;
	}
	
	public Road(Vertex start, Vertex end, Color color) {
		if (start.getX() <= end.getX()) {
			x1 = start.getX();
			x2 = end.getX();
			y1 = start.getY();
			y2 = end.getY();
		}
		else {
			x1 = end.getX();
			x2 = start.getX();
			y1 = end.getY();
			y2 = start.getY();
		}
		this.color = color;
		this.visible = true;
	}
	
	public void draw(Graphics g) {
		if (visible == true) {
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
}
