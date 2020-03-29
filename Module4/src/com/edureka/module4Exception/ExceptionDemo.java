package com.edureka.module4Exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		int arr[] = new int[10];
		// Initialize array with values
		for(int i = 0; i < arr.length; i++){
			arr[i] = i + 1;
		}
		System.out.println(" The values of array are : ");
		
		try {
			for(int i = 0; i <= arr.length; i++){
				System.out.println("arr[" + i + "] is " + arr[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
