package catan;

public class RandomGenerator {
	/**
	 * Can take in 1 or 2 inputs and randomly generates a number
	 */
	private int num1;
	private int num2;

	/**
	 * Constructors One constructor for each number of variables the class can be
	 * initialized with
	 */
	public RandomGenerator(int input1, int input2) {
		this.num1 = input1;
		this.num2 = input2;
	}

	public RandomGenerator(int input1) {
		this.num1 = input1;
		this.num2 = 0;
	}

	public RandomGenerator() {
		this.num1 = 0;
		this.num2 = 0;
	}

	/**
	 * Takes both inputs and returns a single random number between 1 and num1 +
	 * num2
	 */
	public int getRandom() {
		int first = (int) (Math.random() * ((num1 - 1) + 1) + 1);
		int second = (int) (Math.random() * ((num2 - 1) + 1) + 1);
		return first + second;
	}

}
