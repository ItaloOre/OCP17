package com.oracle.ocp.concurrency;

/**
 * @author Italo Oré
 * 
 * Chapter 13 Concurrency
 * 
 */
public class Cap13 {

	public static void main(String[] args) {

		//test1();
		test2();
	}

	//Usando Runnable
	static void test1() {
		Runnable printinventory = () -> System.out.println("Print zoo inventory");

		Runnable printRecord = () -> {
			for(int i = 0;i < 3; i++){
				System.out.println("Printing record: " + i);
			}
		};

		//LA SALIDA ES IMPREDECIBLE
		System.out.println("begin");
		//new Thread(printinventory).run(); RUN NO INICIA HILOS
		new Thread(printinventory).start();
		new Thread(printRecord).start();
		new Thread(printinventory).start();
		System.out.println("end");
	}

	//Usando Thread.sleep
	private static void test2() {

		var job = new Thread(() -> pause());
		job.setDaemon(true);//Si solo queda demon, el programa termina. en este caso no espera a que termine el hilo.
		job.start();//RECIEN COMIENZA EL HILO
		System.out.println("Main finished!!!");
	}

	private static void pause() {
		try {
			Thread.sleep(10_000);
		}catch (InterruptedException e){

		}
		System.out.println("Thread finished!!!");
	}




}
