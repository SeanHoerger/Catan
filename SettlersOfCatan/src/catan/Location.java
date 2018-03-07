package catan;

// this is a class that is quickly used to store the location of an object

public class Location {

	private final int x; // x position
	private final int y; // y postion

	// no argument constructor
	public Location() {
		this.x = 0;
		this.y = 0;
	}

	// creates a Location that stores the corresponding x and y values
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// getters
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// toString
	@Override
	public String toString() {
		return "Location: (" + this.getX() + ", " + this.getY() + ")";
	}
}
