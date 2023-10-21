package com.oracle.ocp.exceptionsLocalization;

import java.io.IOException;

/**
 * @author Italo Oré
 * 
 * Chapter 11 Exceptions and Localization 
 * 
 */
public class Cap11 {
	private static final String SEPARADOR = "----------------";

	public static void main(String[] args) throws Exception {

		//test1(null);
		System.out.println(goHome());

	}

	static void test1(String input) throws Exception {
		if(input == null){
			//throw new Exception();
			//throw new Exception("NOOOO");
			//throw new RuntimeException();
			var e = new RuntimeException("GOKUUU AHHHHH!!!");
			throw e;
		}
		System.out.println(input.toLowerCase());//Posible null
	}

	static void fall(int distance) {
		if(distance > 10){
			try {
				throw new IOException();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static int goHome() { //retorna 1,3 y retorna -3, el return es ignorado.
		try {
			// Optionally throw an exception here
			System.out.print("1");
			return -1;
		} catch (Exception e) {
			System.out.print("2");
			return -2;
		} finally {
			System.out.print("3");
			return -3;
		}
	}

}
