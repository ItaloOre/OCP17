package com.oracle.ocp.makingDecisions;

/**
 * @author Italo Oré
 * 
 * Chapter 3 Making Decisions
 * 
 */
public class Cap3 {
	
	public static void main(String[] args) {

		newSwitch();

	}

	static void newSwitch() {

		int measurement = 777;
		switch (measurement) {
		case 5, 6 -> System.out.println(1);
		case 10 -> {
			System.out.println(2);
			System.out.println(12);
			// yield "";
		}
		// default -> System.out.println(3);
		case 20 -> System.out.println(4);
		case 40 -> System.out.println(5);
		case 50 -> System.out.println(6);
		}
	}

	void printReptile(int category) {
		var type = switch (category) {
		case 1, 2 -> "Snake";
		case 3, 4 -> "Lizard";
		case 5, 6 -> "Turtle";
		case 7, 8 -> "Alligator";
		default -> throw new IllegalArgumentException("Unexpected value: " + category);
		};
		System.out.println(3 + "Turtle"); 
		System.out.print(type);
	}

}
