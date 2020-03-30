package com.edureka.Hashtable;

import java.util.Hashtable;
import java.util.Iterator;

public class HashTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<Integer, Student> hash_table = new Hashtable<Integer, Student>();
		Student s1 = new Student(1, "Akshay", 67);
		Student s2 = new Student(2, "Deepak", 45);
		Student s3 = new Student(3, "Mohit", 89);
		Student s4 = new Student(4, "Pawan", 76);
		Student s5 = new Student(5, "Rajesh", 56);
		
		hash_table.put(1, s1);
		hash_table.put(2, s2);
		hash_table.put(3, s3);
		hash_table.put(4, s4);
		hash_table.put(5, s5);
		
		System.out.println("Students added in the hash table are:");
		Iterator<Integer> it = hash_table.keySet().iterator();
		while(it.hasNext()){
			System.out.println(hash_table.get(it.next()));
		}
		HashTableDemo ht = new HashTableDemo();
		Student s = ht.calculateMaxMarks(hash_table);
		System.out.println("Student with highest marks is " + s.name + " with marks " + s.marks);
	}
	
	private Student calculateMaxMarks(Hashtable<Integer, Student> h){
		int maxMarks = 0;
		Student s = null;
		Student s1 = null;
		
		Iterator<Integer> it = h.keySet().iterator();
		while(it.hasNext()){
			s = h.get(it.next());
			if(s.marks > maxMarks){
				maxMarks = s.marks;
				s1 = s;
			}
			
		}
		return s1;
	}

}
