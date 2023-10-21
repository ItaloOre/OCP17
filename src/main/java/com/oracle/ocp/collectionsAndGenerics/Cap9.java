package com.oracle.ocp.collectionsAndGenerics;

import java.util.LinkedList;

/**
 * @author Italo Oré
 * 
 * Chapter 9 Collections and Generics
 * 
 */
public class Cap9 {

	public static void main(String[] args) {

		var list = new LinkedList<Integer>();
		list.add(3);
		list.add(2);
		list.add(1);
		list.remove(2);//USA EL INDICE
		list.remove(Integer.valueOf(2));//OBJETO
		System.out.println(list);

	}


}
