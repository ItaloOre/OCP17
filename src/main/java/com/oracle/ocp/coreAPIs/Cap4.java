package com.oracle.ocp.coreAPIs;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * @author Italo Oré
 * 
 * Chapter 4 Core APIs
 * 
 */
public class Cap4 {

	private static final String SEPARADOR = "----------------";

	public static void main(String[] args) {

		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}
	
	//Jugando con valores String
	public static void test1() {
		String name = "fluffy"; //APUNTA AL POOL
		String name2 = new String("fluffy"); //APUNTA AL OBJETO
		String name3 = name;//APUNTA AL POOL
		String name4 = """
				fluffy""";
		int three = 3;
		String foor = "4";
		var s = "1";
		s += "2";
		s += "3";
		int[] array = {1,2,3,4,5}; //EL length no usa PARENTESIS
		String cadena = "animals";

		System.out.println(s);
		System.out.println(name == name2);//false
		System.out.println(name == name3);//true
		System.out.println(name == name4);//true
		System.out.println("a" + 1 + 2);//a12
		System.out.println("a" + null);//anull
		System.out.println(1 + 2 + 3 + foor);//64
		System.out.println(s);
		System.out.println(s.length());
		System.out.println(array.length);//EL length no usa PARENTESIS
		//System.out.println(cadena.charAt(7));//ERROR EN TIEMPO DE EJECUCION
		System.out.println(cadena.indexOf('n'));//SOLO PARA CHAR, -1 sino lo encuentra
		System.out.println(cadena.indexOf("al"));//ACEPTA CADENA DE TEXTO -1 sino lo encuentra
		System.out.println(cadena.indexOf("al",2));//ACEPTA CADENA DE TEXTO -1 sino lo encuentra
		System.out.println(cadena.substring(3));//mals
		System.out.println(cadena.substring(3,4));//ma INDEX 3 SIEMPRE, 4 MENOS 1 (imprime m)
		System.out.println(cadena.substring(6,7));//mals
		//System.out.println(cadena.substring(3,2));//EXCEPTION
		System.out.println(cadena.toUpperCase());
		System.out.println("Abc123".toLowerCase());
		System.out.println("Abc123".equalsIgnoreCase("ABC123"));

		var d = new Duck();
		d.name = "Mc Pato";
		// d.intern(); NO EXISTE
		System.out.println(d.toString());// LLAMA al to String del objeto.
		System.out.println("Mc".startsWith("M"));
		System.out.println("Mc".endsWith("M"));
		System.out.println("Mc".contains("b"));
		System.out.println("abcdef".replace('a','z'));
		System.out.println("abcdefab".replace("ab","zz"));
		System.out.println("abcdefab".replace("ab",new String("ss")));
		// CharSequence es una interfaz, la clase Sting implementa esa interfaz
		String text = "\t\u2000 abc\u2000\n"; // u2000 es el espacio en blanco en unicode
		System.out.println(text.length());
		System.out.println(text.trim().length());
		System.out.println(text.strip().length());//Stip si reconoce unicode y lo elimina

		String text2 = "\t abc\t";
		System.out.println(text2.length());
		System.out.println(text2);
		System.out.println(text2.stripLeading());//Te borra por izquierda
		System.out.println(text2.stripTrailing());//Te borra por derecha



		System.out.println(SEPARADOR);
	}

	//Jugando con valores String parte 2
	public static void test2() {

		var block = """
				a
				 b
				c""";

		var concat = " a\n"
				+"  b\n"
				+" c";

		System.out.println(block.length());//Ojo con el cambio de linea 6
		System.out.println(concat.length());//9

		//System.out.println(block.indent(0).length());//No hace ni mrd
		System.out.println(block.indent(1).length());//Agrega un espacio al inicio de cada linea y al final un cambio de linea si le falta 10

		System.out.println(concat.indent(-1).length());//Elimina un espacio al inicio de cada linea
		System.out.println(concat.indent(-4).length());//Elimina cuatro espacio al inicio de cada linea al final un cambio de linea si le falta 7
		System.out.println(concat.stripIndent().length());//Remueve el primer espacio de cada linea 6

		var str = "1\\t2";
		System.out.println(str);
    	System.out.println(str.translateEscapes());//Traduce los cartere espsciales de tabulacion, salto de linea, etc;

		System.out.println(" ".isEmpty());
		System.out.println("".isEmpty());
		System.out.println(" ".isBlank());
		System.out.println("".isBlank());
		System.out.println("".isBlank());

		var name22 = "Miryan";
		var orderId = 5;

		System.out.println("Hello " + name22 + ", your order " + orderId + " is ready");
		System.out.println(String.format("Hello %s, your order %d is ready",name22,orderId));
		System.out.println("Hello %s, your order %d is ready".formatted(name22,orderId)); //NUEVO DESDE JAVA 15

		var name33 = "Jens";
		var score = 90.25;
		var total = 100;

		System.out.println("%s%n, Score: [%2.2f] out of %d".formatted(name33,score,total));
		//System.out.println("Score:%f".formatted(score)); IlegarFormatConversionException

		var name = "Hello World";
		var name2 = new String("Hello World").intern(); //Busca en el pool de String
		System.out.println(name == name2);//TRUE

		System.out.println(SEPARADOR);
	}

	//Jugando con String Builder
	public static void test3() {
		String alpha0 = "";
		for (char c = 'a'; c <= 'z';c++){
			alpha0 += c;
		}
		System.out.println(alpha0);

		StringBuilder alpha = new StringBuilder();
		for (char current='a';current<= 'z';current++) {
			alpha.append(current);
		}
		System.out.println(alpha);

		StringBuilder sb = new StringBuilder("star");
		sb.append("+middle");
		sb.append("+end");
		System.out.println(sb);

		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a.append("de");
		b = b.append("f").append("g");
		System.out.println("a="+a);//EL a TAMBIEN SE MODIFICA
		System.out.println("b="+b);

		//PROPIOS DE StringBuilder
		var sb2 = new StringBuilder("animals");
		sb2.insert(7,"-");
		System.out.println(sb2);
		sb2.delete(1,3);
		System.out.println(sb2);
		sb2.delete(1,100);//NO da EXCEPTION
		//sb.deleteCharAt(100);EXCEPTION
		var sb3 = new StringBuilder("ABC");
		System.out.println(sb3.reverse());

		System.out.println(SEPARADOR);
	}

	//Jugando con Array
	public static void test4() {
		int[] a,b; //AMBOS SON ARRAY
		int c[],d; //SOLO C ES ARRAY

		int[] numbers = {2,4,6,8};
		//EL arrayo tiene que estar ordenado
		System.out.println(Arrays.binarySearch(numbers,2));//0
		System.out.println(Arrays.binarySearch(numbers,4));//1
		//No lo encuentra pero deberia estar lo pones en negativo y le restas 1
		System.out.println(Arrays.binarySearch(numbers,1));//-1
		System.out.println(Arrays.binarySearch(numbers,3));//-2
		System.out.println(Arrays.binarySearch(numbers,9));//-5

		int[] numbers1 = {1,2,3};
		int[] numbers2 = {1,2,3};

		System.out.println(numbers1.equals(numbers2));//false
		System.out.println(Arrays.compare(numbers1,numbers2));//0
		System.out.println(Arrays.mismatch(numbers1,numbers2));//-1

		double num = Math.random(); // 0.0 <= 1.0
		System.out.println(num);


		System.out.println(SEPARADOR);
	}

	//Jugando con import java.time.*
	public static void test5() {
		System.out.println(ZonedDateTime.now());

		var date = LocalDate.of(2022, Month.JANUARY, 20);
		System.out.println(date); // 2022–01–20
		date = date.plusDays(2);
		System.out.println(date); // 2022–01–22
		date = date.plusWeeks(1);
		System.out.println(date); // 2022–01–29
		date = date.plusMonths(1);
		System.out.println(date); // 2022–02–28 AÑOS VISIESTO SI TIENE 29-02, AÑO VISIESTOS MULTIPLOS DE 4 O 400
		date = date.plusYears(5);
		System.out.println(date); // 2027–02–28
		date = date.minusYears(5);
		System.out.println(date); // 2026–02–28

		var date2 = LocalDate.of(2024, Month.JANUARY, 20);
		var time = LocalTime.of(5, 15);
		var dateTime = LocalDateTime.of(date2, time);
		System.out.println(dateTime); // 2024–01–20T05:15
		dateTime = dateTime.minusDays(1);
		System.out.println(dateTime); // 2024–01–19T05:15
		dateTime = dateTime.minusHours(10);
		System.out.println(dateTime); // 2024–01–18T19:15
		dateTime = dateTime.minusSeconds(30);
		System.out.println(dateTime); // 2024–01–18T19:14:30
	}

	//Jugando con periodos java.time.Period y java.time.Duration
	public static void test6() {
		var date = LocalDate.of(2022,1,20);
		var time = LocalTime.of(6,15);
		var dateTime = LocalDateTime.of(date,time);
		var period = Period.ofMonths(1);

		System.out.println(date.plus(period)); // TemporalAmount es padre de ChronoPeriod y esto es la interfaz que implementa el Period
		System.out.println(dateTime.plus(period));// El plus acepta periodos pero mucho cuidado con la siguiente linea
		//System.out.println(time.plus(period));RUNTIME EXECEPTION .UnsupportedTemporalTypeException

		var daily = Duration.of(1, ChronoUnit.DAYS);

		var one = LocalTime.of(5,15);
		var two = LocalTime.of(6,30);
		System.out.println(ChronoUnit.HOURS.between(one,two));
		System.out.println(ChronoUnit.MINUTES.between(one,two));

		LocalTime time2 = LocalTime.of(3,12,45);
		System.out.println(time2);
		System.out.println(time.truncatedTo(ChronoUnit.MINUTES));

		var zone = ZoneId.of("US/Eastern");
		var zonedDateTime = ZonedDateTime.of(date,time,zone);
		System.out.println(zonedDateTime);//2022-01-20T06:15-05:00[US/Eastern]
		System.out.println(zonedDateTime.toInstant());// 2022-01-20T11:15:00Z

		var date5 = LocalDate.of(22,Month.MARCH,13);
		var time5 = LocalTime.of(2,30);
		var zone5 = ZonedDateTime.of(date,time,zone);
		var dateTime5 = ZonedDateTime.of(date,time,zone);
		System.out.println(dateTime);
	}

	//PREGUNTAS DEL LIBRO
	public static void test7() {
		//String cadena = 2 + 3; Error
		Object[][][] values = new Object[3][0][5];
		var doubles = new double[] {1.0,2,4f};
	}


}
