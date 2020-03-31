package com.edureka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edureka.bean.Student;

public class JDBCDemo {

	Connection con;
	Statement stmt;
	PreparedStatement pst;
	public void createConnection() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			System.out.println("Connection created");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createTable() {
		// TODO Auto-generated method stub
		String query = "create table student (id int(10), name varchar(20), class varchar(20), marks int(10))";
		try {
			stmt = con.createStatement();
			stmt.execute(query);
			System.out.println("query executed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertStudent(Student s) {
		// TODO Auto-generated method stub
		int id = s.getStudentID();
		String name = s.getName();
		String studentClass = s.getStudentClass();
		int marks = s.getMarks();
		
		try {
			pst = con.prepareStatement("insert into student values (?, ?, ?, ?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setString(3, studentClass);
			pst.setInt(4, marks);
			pst.execute();
			System.out.println("Students inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		String name = s.getName();
		
		try {
			pst = con.prepareStatement("update student set marks = ? where name = ?");
			pst.setInt(1, 60);
			pst.setString(2, name);
			pst.executeUpdate();
			System.out.println("Student updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void deleteStudent(Student s) {
		// TODO Auto-generated method stub
		String name = s.getName();
		
		try {
			pst = con.prepareStatement("delete from student where name = ?");
			pst.setString(1, name);
			pst.executeUpdate();
			System.out.println("Student deleted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getStudent() {
		// TODO Auto-generated method stub
		try {
			pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "+ rs.getString(3) + " " + rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void batchUpdate() {
		// TODO Auto-generated method stub
		try {
			stmt = con.createStatement();
			con.setAutoCommit(false);
			stmt.addBatch("insert into student values(106, 'Neel', '8th', 34)");
			stmt.addBatch("insert into student values(107, 'Rob', '3rd', 55)");
			stmt.addBatch("insert into student values(108, 'Dylan', '8th', 88)");
			
			stmt.executeBatch();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	public void closeConnections() {
		// TODO Auto-generated method stub
		try {
			if(stmt != null)
				stmt.close();
				if(pst != null)
				pst.close();
				if(con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
