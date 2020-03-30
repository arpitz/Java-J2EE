package com.edureka.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee e1 = new Employee(101, "John", 25000, 23);
		Employee e2 = new Employee(102, "Mark", 12000, 30);
		Employee e3 = new Employee(103, "Sara", 45000, 45);
		Employee e4 = new Employee(104, "Ben", 8900, 20);
		Employee e5 = new Employee(105, "Josh", 33000, 38);
		
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		map.put(101, e1);
		map.put(102, e2);
		map.put(103, e3);
		map.put(104, e4);
		map.put(105, e5);
		
		System.out.println("The objects added in Hashmap are :");
		
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			System.out.println(map.get(it.next()));
		}
	}

}
