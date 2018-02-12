package catan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


// This class is where the visuals are displayed. It also contains the main method.

public class BoardDisplay extends JComponent {

	public static final int XDIM = 300;
	public static final int YDIM = 300;
	public static final int SCALAR = 26;
	public static final int XSTART = 10*SCALAR;
	public static final int YSTART = SCALAR;
	
	private static final BoardData boardData = new BoardData();
	
	public static void main (String[] args){
		JFrame window = new JFrame("Stags of Catan");
		window.add(new BoardDisplay());
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setLocationRelativeTo(null);
		window.setVisible(true);		
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(XDIM, YDIM);
	}
	
	protected void paintComponent(Graphics g) {
		// print all tiles
		for(int i = 0; i < boardData.getTiles().length; i++) {
			boardData.getTileAt(i).drawTile(g);
		}
	}
}
