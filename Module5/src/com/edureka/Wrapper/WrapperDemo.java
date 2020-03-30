package com.edureka.Wrapper;

public class WrapperDemo {

	public static void main(String[] args) {
		
		System.out.println("Wrapper class examples for Java 1.5 & above");
		int a = 10;
		Integer i = a;
		int a1 = i.intValue();
		System.out.println("Wrapper class Integer: " + i);
		System.out.println("integer value from Wrapper class: " + a1);
		
		byte b = 100;
		Byte by = b;
		byte b1 = by.byteValue();
		System.out.println("Wrapper class Byte: " + by);
		System.out.println("byte value from Wrapper class: " + b1);

		short s = 2589;
		Short sh = s;
		short s1 = sh.shortValue();
		System.out.println("Wrapper class Short: " + sh);
		System.out.println("short value from Wrapper class: " + s1);

		long l = 100000L;
		Long lo = l;
		long l1 = lo.longValue();
		System.out.println("Wrapper class Long: " + lo);
		System.out.println("long value from Wrapper class: " + l1);
		
		float f = 23.78f;
		Float fl = f;
		float f1 = fl.floatValue();
		System.out.println("Wrapper class Float: " + fl);
		System.out.println("float value from Wrapper class: " + f1);

		double d = 234.78945d;
		Double dbl = d;
		double d1 = dbl.doubleValue();
		System.out.println("Wrapper class Double: " + dbl);
		System.out.println("double value from Wrapper class: " + d1);


	}

}
