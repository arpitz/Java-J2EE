package com.edureka.module4MultiThreading;

public class ThreadDemo implements Runnable {

	public static void main(String[] args) {
		System.out.println("From the Main thread");
		System.out.println("20 even numbers are:");
		for(int i = 1; i <= 20; i++){
			System.out.println(i*2);
		}
		
		ThreadDemo t1 = new ThreadDemo();
		Thread t =new Thread(t1); 
		t.start();

	}

	@Override
	public void run() {
		System.out.println("From New Thread");
		System.out.println("Table of 5 is:");
		for(int i = 1; i <= 10; i++){
			System.out.println(5 * i);
		}
	}

}
