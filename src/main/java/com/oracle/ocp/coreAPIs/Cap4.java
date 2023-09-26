package com.oracle.ocp.coreAPIs;

/**
 * @author Italo Oré
 * 
 * Chapter 4 Core APIs
 * 
 */
public class Cap4 {
	
	public static void main(String[] args) {

		fly(2);

	}
	
	//Que pasa si tengo esta implementacion? Utiliza el nativo
	public static void fly(int numMiles) {System.out.println(1);}
	public static void fly(Integer numMiles) {System.out.println(6);}



}
