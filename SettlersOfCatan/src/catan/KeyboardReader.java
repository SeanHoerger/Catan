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
	private boolean rightPressed = false;
	private boolean leftPressed = false;
	private boolean enterPressed = false;
	
	private static final char BUILD = 'b';
	private static final char END = 'd';
	private static final char ROLL = 'r';
	private static final char RIGHT = KeyEvent.VK_RIGHT;
	private static final char LEFT = KeyEvent.VK_LEFT;
	private static final char ENTER = KeyEvent.VK_ENTER;

	
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
		case RIGHT:
			rightPressed = true;
			break;
		case LEFT:
			leftPressed = true;
			break;
		case ENTER:
			enterPressed = true;
			break;
		default:
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
	
	public boolean rightIsPressed() {
		if(rightPressed) {
			rightPressed = false;
			return true;
		}
		return false;
	}

	public boolean leftIsPressed() {
		if(leftPressed) {
			leftPressed = false;
			return true;
		}
		return false;
	}
	
	public boolean enterIsPressed() {
		if(enterPressed) {
			enterPressed = false;
			return true;
		}
		return false;
	}
	
}
