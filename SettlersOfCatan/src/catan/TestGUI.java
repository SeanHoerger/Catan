package catan;

import javax.swing.*;
import java.awt.*;

//the point of this program is to experiment with graphics?

public class TestGUI extends JComponent{
	
	private final int XDIM = 1440;
	private final int YDIM = 900;
	
	private final int SCALAR = 30;
	private final int XSTART = 10*SCALAR;
	private final int YSTART = SCALAR;
	
	public static void main (String[] args){
		JFrame window = new JFrame("Stags of Catan");
		window.add(new TestGUI());
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(XDIM, YDIM);
	}
	
	protected void paintComponent(Graphics g) {
		int xPos = XSTART;
		int yPos = YSTART;
		
		// row one - 3 tiles
		for(int r1 = 0; r1 < 3; r1++) {
			g.drawPolygon(this.getHexagon(xPos, yPos, SCALAR));
			xPos = xPos + 6*SCALAR;
		}
		xPos = XSTART-3*SCALAR;
		yPos = yPos+5*SCALAR;
		
		//row two - 4 tiles
		for(int r2 = 0; r2 < 4; r2++) {
			g.drawPolygon(this.getHexagon(xPos, yPos, SCALAR));
			xPos = xPos + 6*SCALAR;
		}
		xPos = XSTART-6*SCALAR;
		yPos = yPos+5*SCALAR;
		
		//row three - 5 tiles
		for(int r3 = 0; r3 < 5; r3++) {
			g.drawPolygon(this.getHexagon(xPos, yPos, SCALAR));
			xPos = xPos + 6*SCALAR;
		}
		xPos = XSTART-3*SCALAR;
		yPos = yPos+5*SCALAR;
		
		// row four - 4 tiles
		for(int r4 = 0; r4 < 4; r4++) {
			g.drawPolygon(this.getHexagon(xPos, yPos, SCALAR));
			xPos = xPos + 6*SCALAR;
		}
		xPos = XSTART;
		yPos = yPos+5*SCALAR;
		
		// row five - 3 tiles
		for(int r5 = 0; r5 < 3; r5++) {
			g.drawPolygon(this.getHexagon(xPos, yPos, SCALAR));
			xPos = xPos + 6*SCALAR;
		}
	}
	
	private Polygon getHexagon(int x, int y, int scalar) {
		int[] xValues = {x, x+3*scalar, x+3*scalar, x+0*scalar, x-3*scalar, x-3*scalar};
		int[] yValues = {y, y+2*scalar, y+5*scalar, y+7*scalar, y+5*scalar, y+2*scalar};
		Polygon hex = new Polygon(xValues, yValues, 6);
		return hex;
	}
}
