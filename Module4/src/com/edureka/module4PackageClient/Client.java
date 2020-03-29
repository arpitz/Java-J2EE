package com.edureka.module4PackageClient;

import com.edureka.module4Package.*;

public class Client extends PackageDemo {

	public static void main(String[] args) {
		PackageDemo p1 = new PackageDemo();
		p1.subtract(20, 5);
		p1.multiply(12, 5);
		p1.divide(20, 3);
		p1.factorial(5);
		p1.reverse(278);
	}

}
