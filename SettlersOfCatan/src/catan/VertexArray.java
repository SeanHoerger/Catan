package catan;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class VertexArray {
	
	private Vertex[] vertexes;
	
	public VertexArray(){
		vertexes = new Vertex[54];
		
		for(int i = 0; i < vertexes.length; i++) {
			vertexes[i] = new Vertex();
		}
		
		this.setLocations();
	}
	
	public void addNeighbor(int i, Tile neighbor) {
		vertexes[i].addNeighbor(neighbor);
	}
	
	public void test(Graphics g) {
		for(int i = 0; i < vertexes.length; i++) {
			Vertex vertex = vertexes[i];
			g.setColor(Color.BLACK);
			g.setFont(new Font (Font.SANS_SERIF, Font.BOLD, BoardDisplay.SCALAR));
			g.drawString("" + i, vertex.getX(), vertex.getY());
		}
	}
	
	private void setLocations() {
		int xPos = BoardDisplay.XSTART;
		int yPos = BoardDisplay.YSTART;
		int i = 0;
		
		// row one - 3 vertexes
		for(int j = 0; j < 3; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-3*BoardDisplay.SCALAR;
		yPos = yPos+2*BoardDisplay.SCALAR;
		
		// row two - 4 vertexes
		for(int j = 0; j < 4; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-3*BoardDisplay.SCALAR;
		yPos = yPos+3*BoardDisplay.SCALAR;

		// row three - 4 vertexes
		for(int j = 0; j < 4; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-6*BoardDisplay.SCALAR;
		yPos = yPos+2*BoardDisplay.SCALAR;
		
		// row four - 5 vertexes
		for(int j = 0; j < 5; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-6*BoardDisplay.SCALAR;
		yPos = yPos+3*BoardDisplay.SCALAR;
		
		// row five - 5 vertexes
		for(int j = 0; j < 5; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-9*BoardDisplay.SCALAR;
		yPos = yPos+2*BoardDisplay.SCALAR;
		
		// row six - 6 vertexes
		for(int j = 0; j < 6; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-9*BoardDisplay.SCALAR;
		yPos = yPos+3*BoardDisplay.SCALAR;
		
		// row seven - 6 vertexes
		for(int j = 0; j < 6; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-6*BoardDisplay.SCALAR;
		yPos = yPos+2*BoardDisplay.SCALAR;
		
		// row eight - 5 vertexes
		for(int j = 0; j < 5; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-6*BoardDisplay.SCALAR;
		yPos = yPos+3*BoardDisplay.SCALAR;
		
		// row nine - 5 vertexes
		for(int j = 0; j < 5; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-3*BoardDisplay.SCALAR;
		yPos = yPos+2*BoardDisplay.SCALAR;
		
		// row ten - 4 vertexes
		for(int j = 0; j < 4; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART-3*BoardDisplay.SCALAR;
		yPos = yPos+3*BoardDisplay.SCALAR;
		// row eleven - 4 vertexes
		for(int j = 0; j < 4; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
		xPos = BoardDisplay.XSTART;
		yPos = yPos+2*BoardDisplay.SCALAR;
		
		// row twelve - 3 vertexes
		for(int j = 0; j < 3; j++) {
			vertexes[i] = new Vertex(xPos, yPos, 0);
			xPos = xPos+6*BoardDisplay.SCALAR;
			i++;
		}
	}
	
}
