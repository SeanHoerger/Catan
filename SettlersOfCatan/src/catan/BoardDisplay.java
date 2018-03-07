package catan;

import javax.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This class is where the visuals are displayed. It also contains the main method.

public class BoardDisplay extends JComponent {

	public static final int XDIM = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final int YDIM = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static final int SCALAR = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 55); // <-- magic number: 55
	public static final int XSTART = 10*SCALAR;
	public static final int YSTART = SCALAR;
	

	private static final BoardData boardData = new BoardData();

	public static void main(String[] args) {
		 try {
	            // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		JFrame window = new JFrame("Stags of Catan");
		window.add(new BoardDisplay());
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setLocationRelativeTo(null);
		//window.setBackground(new Color(114, 162,254));<- save for later
		window.setVisible(true);
		Hand starter = new Hand(0,0,0,0,0);
		Player player1 = new Player(1, starter);
		Player player2 = new Player(2, starter);
		TurnTracker turns = new TurnTracker(window, SCALAR, player1, player2);
		//turns.addEndTurnButton();
		

	}

	public Dimension getPreferredSize() {
		return new Dimension(XDIM, YDIM);
	}
	
	protected void paintComponent(Graphics g) {
		this.update(g);
	}
	
	public void update(Graphics g) {
		// print all tiles
		for(int i = 0; i < boardData.getTiles().length; i++) {
			boardData.getTileAt(i).drawTile(g);
		}
		
		// card test
		//Hand testHand = new Hand(8,0,2,3,12);
		//Player testPlayer = new Player(1, testHand);
		//testPlayer.displayHand(g);
	}
	
	
}
