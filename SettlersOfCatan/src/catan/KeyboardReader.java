package catan;

import java.awt.*;



import java.awt.event.*;
import javax.swing.*;

public class KeyboardReader implements KeyListener {
	
	public KeyboardReader() {
		
	}

	private boolean buildPressed = false;
	private boolean endTurnPressed = false;
	private boolean rollDicePressed = false;
	
	private static final char BUILD = 'b';
	private static final char END = 'd';
	private static final char ROLL = 'r';
	
	//KeyEvent.VK_ENTER
	//KeyEvent.VK_LEFT
	//KeyEvent.VK_RIGHT
	
	public void keyPressed(KeyEvent evt) {
		
		switch (evt.getKeyChar()) {
		case BUILD:
			buildPressed = true;
			break;
		case ROLL:
			rollDicePressed = true;
			break;
		case END:
			endTurnPressed = true;
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
	
	public boolean buildIsPressed() {
		if(buildPressed) {
			buildPressed = false;
			return true;
		}
		return false;
	}
	
	public boolean endTurnIsPressed() {
		if(endTurnPressed) {
			endTurnPressed = false;
			return true;
		}
		return false;
	}
	
	public boolean rollDiceIsPressed() {
		if(rollDicePressed) {
			rollDicePressed = false;
			return true;
		}
		return false;
	}
	
}
