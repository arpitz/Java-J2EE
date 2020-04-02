package com.edureka.bean;

public class Student {
	
	Integer id;
	String name;
	Integer marks;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(Integer id, String name, Integer marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
}
