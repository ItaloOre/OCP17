package com.oracle.ocp.makingDecisions;

import java.util.List;

/**
 * @author Italo Oré
 * 
 * Chapter 3 Making Decisions
 * 
 */
public class Cap3 {

	private static final String SEPARADOR = "----------------";

	public static void main(String[] args) {
		test1();
	}

	static void test1() {
		compareIntegers(Integer.valueOf(5));
		compareIntegers(Integer.valueOf(3));
		compareIntegers(Integer.valueOf(8));
		compareIntegers(Double.valueOf(8.88));
	}

	static void compareIntegers(Number number){
		//NO SE PUEDE HACER UN INSTANCE OF DE NUMBER A NUMBER, lo de la derecha tiene que se subtipo cuando se usa PATTER MATCHING.
		if(number instanceof final Integer data){ //Patter matching nuevo en JAVA 17
			//Integer data = (Integer) number;
			//data = 10 MALA PRACTICA REASIGNAR UN Patter matching
			System.out.println(data.compareTo(5)); //RETORNA -1 SI ES MENOS, 0 SI ES IGUAL O 1 SI ES MAYOR
		} else{
			System.out.println("No soy integer");
		}
		System.out.println(SEPARADOR);
	}

	static void compareIntegerWith(){
		Number value = 123;
		if(value instanceof List data){

		}
	}

	void printIntegerOrNumberGreaterThan5(Number number){
		//if(number instanceof Integer data || data.compareTo(5) > 0){ ERROR DE FLOW SCOPING
			//System.out.println(data);
		//}
	}

	void printIntegerTwice(Number number){
		if(number instanceof Integer data){
			System.out.println(data.intValue());
		}
		//System.out.println(data.intValue()); ERROR DE FLOW SCOPING
	}
	void printIntegerTwice2(Number number){
		if(!(number instanceof Integer data)){
			return;
		}
		System.out.println(data.intValue());
	}



}
