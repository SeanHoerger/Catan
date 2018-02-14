package catan;

import javax.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This class is where the visuals are displayed. It also contains the main method.

public class BoardDisplay extends JComponent {

	//private Graphics theScreen;
	public static final int XDIM = 300;
	public static final int YDIM = 300;
	public static final int SCALAR = 24;
	public static final int XSTART = 10 * SCALAR;
	public static final int YSTART = SCALAR;
	


	private static final BoardData boardData = new BoardData();

	public static void main(String[] args) {
		JFrame window = new JFrame("Stags of Catan");
		window.add(new BoardDisplay());
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		Hand starter = new Hand(0,0,0,0,0);
		Player player1 = new Player(1, starter);
		Player player2 = new Player(2, starter);
		TurnTracker turns = new TurnTracker(window, SCALAR, player1, player2);
		turns.addEndTurnButton();
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(XDIM, YDIM);
	}

	protected void paintComponent(Graphics g) {
		// print all tiles
		for (int i = 0; i < boardData.getTiles().length; i++) {
			boardData.getTileAt(i).drawTile(g);
		}
	}
	
	//Experimenting with a new way to update the board
	/*void updateGraphics() {
		this.clear();
		this.paintComponent(theScreen);
	}
	
	void clear() {
		this.theScreen.setColor(Color.GRAY);
	}*/
	
}
