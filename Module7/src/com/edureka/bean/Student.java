package com.edureka.bean;

public class Student {
	private int studentID;
	private String name, studentClass;
	private int marks;
	public Student(int studentID, String name, String studentClass, int marks) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.studentClass = studentClass;
		this.marks = marks;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

}
