package com.edureka.client;

import com.edureka.bean.Student;
import com.edureka.db.JDBCDemo;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCDemo obj = new JDBCDemo();
		obj.createConnection();
		obj.createTable();
		
		Student s1 = new Student(101, "John", "5th", 78);
		Student s2 = new Student(102, "Ryan", "8th", 56);
		Student s3 = new Student(103, "Lucy", "6th", 45);
		Student s4 = new Student(104, "Mark", "4th", 89);
		Student s5 = new Student(105, "Sarah", "5th", 66);
		
		obj.insertStudent(s1);
		obj.insertStudent(s2);
		obj.insertStudent(s3);
		obj.insertStudent(s4);
		obj.insertStudent(s5);
		
		//obj.updateStudent(s3);
		
		//obj.deleteStudent(s4);
		
		obj.batchUpdate();
		
		obj.getStudent();
		
		obj.closeConnections();

	}

}
