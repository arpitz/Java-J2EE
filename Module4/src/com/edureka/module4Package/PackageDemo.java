package com.edureka.module4Package;

public class PackageDemo {
	
	public void subtract(int x, int y){
		System.out.println("In subtract method of PackageDemo class");
		System.out.println("result is : " + (x - y));
	}
	
	public void multiply(int x, int y){
		System.out.println("In multiply method of PackageDemo class");
		System.out.println("result is : " + (x * y));
	}
	
	public void divide(int x, int y){
		System.out.println("In divide method of PackageDemo class");
		System.out.println("result is : " + (x / y));
	}
	
	public void factorial(int n) {
		int fact = n;
        for(int i = 1; i <= (n - 1); i++){
            fact = fact * (n - i);       
        }
        System.out.println("Factorial of " + n + " is " + fact);
	}
	
	public void reverse(int n) {
		String result = "";
        while(n != 0){
            result += "" + n % 10;
            n = n / 10;
        }
        System.out.println("The Reverse is " + Integer.parseInt(result));
	}
}
