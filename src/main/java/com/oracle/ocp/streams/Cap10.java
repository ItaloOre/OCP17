package com.oracle.ocp.streams;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Italo Oré
 * 
 * Chapter 10 Streams
 * 
 */
public class Cap10 {

	private static final String SEPARADOR = "----------------";

	public static void main(String[] args) {
		newOptional();
		newStream();
		newStream2();

	}

	static void newOptional() {
		Optional<Double> opt = Optional.of(4.7);
		System.out.println(opt.orElseGet(()->Math.random()));
		Optional<Double> opt2 = Optional.empty();
		System.out.println(opt2.orElseGet(()->Math.random()));
		System.out.println(opt2.orElse(Double.NaN));

		Optional<String> opt3 = Optional.of("4.7");
		System.out.println(opt3.orElseGet(()-> "d"));

		Optional<String> opt4 =  Optional.of("4.7");
		System.out.println(opt4.orElse("Error"));
		System.out.println(opt4.orElseThrow());
		System.out.println(SEPARADOR.concat(SEPARADOR));
	}

	private static void newStream() {
		var s1 = Stream.of(1,2,3,4,5);//SIEMPRE CON EL OF
		s1.forEach(System.out::println);
		System.out.println(SEPARADOR);
		var list = List.of("a","b","c");
		Stream<String> fromList = list.stream();

		Stream<Double> randoms = Stream.generate(Math::random);// INFINITO
		Stream<Integer> addNumbers = Stream.iterate(1,n -> n+2);// INFINITO
		//addNumbers.forEach(System.out::println);// INFINITO

		System.out.println();
		Stream<Integer> addNumbers2 = Stream.iterate(1,n -> n+2).limit(5);
		addNumbers2.forEach(System.out::println);
		System.out.println(SEPARADOR);
		Stream<Integer> addNumbers3 = Stream.iterate(1,n -> n<10,n -> n+2);//finito, otra opcion
		addNumbers3.forEach(System.out::println);
		System.out.println(SEPARADOR);

		// Stream<Integer> addNumbers5 = Stream.iterate(1,n -> n+2).limit(5);
		//List<Integer> test2 = addNumbers5.toList();

		//Ejemplo MIN y MAX
		Stream<Integer> addNumbers5 = Stream.iterate(1,n -> n+2).limit(5);
		Optional<Integer> resultado = addNumbers5.min((a1, a2) -> a1 - a2);
		System.out.println(resultado.isPresent() ? resultado : "Nada");
		System.out.println(SEPARADOR.concat(SEPARADOR));
	}

	private static void newStream2() {
		// EJEMPLO DE findAny
		var stream = Stream.of("a","b","c");
		stream.findAny().ifPresent(System.out::println);
		var stream2 = Stream.generate(()-> "italo");
		stream2.findAny().ifPresent(System.out::println);//LO DETIENE
		System.out.println(SEPARADOR);

		// EJEMPLO DE anyMatch,allMatch y noneMatch
		var stream3 = Stream.generate(()-> "italo");
		//var stream4 = Stream.generate(()-> "italo");
		var stream5 = Stream.generate(()-> "italo");
		Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
		System.out.println(stream3.anyMatch(pred));//true
		//System.out.println(stream4.allMatch(pred)); MNUNCA ACABA
		System.out.println(stream5.noneMatch(pred));//false
		System.out.println(SEPARADOR);

		//Ejemplo REDUCE


		var array = new String[]{"i","t","a","l","o"};
		var result = "";

		//EL REDUCE CON 2 PARAMETRO
		Stream<String> stream6 = Stream.of("i","t","a","l","o");
		var a = stream6.reduce("Nombre: ",(s,c) -> s.concat(c));
		System.out.println(a);

		Stream<String> stream7 = Stream.of("i","t","a","l","o");
		var b = stream7.reduce("Nombre: ",String::concat);
		System.out.println(b);

		//EL REDUCE CON 1 PARAMETRO
		Stream<Integer> stream8 = Stream.of(1,2,3,4,5,6,7);
		var c = stream8.reduce(1,(n1,n2) -> n1 * n2);
		System.out.println(c);

		Stream<Integer> stream9 = Stream.of(1,2,3,4,5,6,7);
		var d = stream9.reduce((n1,n2) -> n1 * n2);
		System.out.println(d);

		//EL REDUCE CON 3 ARGUENTOS ES UTIL CUANDO TRABAJAS CON STREAM PARALELOS
		Stream<String> stream10 = Stream.of("i","t","a","l","o!");
		var e = stream10.reduce(0,(n1,n2) -> n1 + n2.length(), (n3,n4) -> n3+n4);
		System.out.println(e);

		System.out.println(SEPARADOR);

		//Ejemplo COLLECT
		Stream<Integer> addNumbers = Stream.iterate(1,n -> n+2).limit(5);
		List<Integer> test1 = addNumbers.collect(Collectors.toList());//Revisar lios metodos de Collectors
		test1.forEach(System.out::println);// FOR EACH NO IMPLEMENTA ITERABR

		System.out.println(SEPARADOR.concat(SEPARADOR));
	}


}
