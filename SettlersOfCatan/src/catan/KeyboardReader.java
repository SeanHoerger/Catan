package catan;

import java.awt.*;



import java.awt.event.*;
import javax.swing.*;

public class KeyboardReader implements KeyListener {
	
	public KeyboardReader() {
		
	}

	private boolean build = false;
	
	private static final char BUILD = 'b';
	private static final char END = 'd';
	
	public void keyPressed(KeyEvent evt) {
		
		switch (evt.getKeyChar()) {
		case BUILD:
			System.out.println("B pressed");
			build = true;
			break;
		case END:
			System.out.println("End button pressed");
			break;
		default:
			System.out.println("Some button pressed");
		}
	}

	public void keyReleased(KeyEvent evt) {
	// Not used
	}

	public void keyTyped(KeyEvent evt) {
	// Not used
	}
	
	public boolean buildPressed() {
		if(build) {
			build = false;
			return true;
		}
		return false;
	}
}
