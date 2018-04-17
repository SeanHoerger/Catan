package catan;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Settlement extends House{

	public Settlement(int x, int y, Player owner) {
		super(x, y, owner);
	}
	
	public void draw(Graphics g) {
		//draw settlement
		
		int x = this.getX();
		int y= this.getY();
		
		int[] xValues = {x, 
				(int)(0.5*BoardDisplay.SCALAR + x), 
				(int)(0.5*BoardDisplay.SCALAR + x), 
				(int)(-0.5*BoardDisplay.SCALAR + x), 
				(int)(-0.5*BoardDisplay.SCALAR + x)};
		
		int[] yValues = {(int)(-0.75*BoardDisplay.SCALAR + y), 
				(int)(-0.25*BoardDisplay.SCALAR + y), 
				(int)(0.5*BoardDisplay.SCALAR + y), 
				(int)(0.5*BoardDisplay.SCALAR + y), 
				(int)(-0.25*BoardDisplay.SCALAR + y)};
		
		Polygon p = new Polygon(xValues, yValues, 5);	
		
		g.setColor(this.getOwner().getColor());
		g.fillPolygon(p);
		g.setColor(Color.BLACK);
		g.drawPolygon(p);
	}
}
