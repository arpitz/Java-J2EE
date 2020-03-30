package com.edureka.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		List<Integer> arr = new ArrayList<Integer>();
		int i = 1;
		while(i <= 10){
			arr.add(i);
			i++;
		}
		Iterator<Integer> it = arr.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
