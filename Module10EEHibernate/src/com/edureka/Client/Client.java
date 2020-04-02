package com.edureka.Client;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.edureka.bean.Student;

public class Client {
	
	private static SessionFactory sf;

	public static void main(String[] args) {
		
		try {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			sf = config.buildSessionFactory();
			System.out.println("Config");
		
			Client c1 = new Client();
			// Inserting students
			/* c1.insertInDatabase(new Student(1, "Mark", 78));
			c1.insertInDatabase(new Student(2, "John", 33));
			c1.insertInDatabase(new Student(3, "Ryan", 56));
			c1.insertInDatabase(new Student(4, "Lucy", 60));
			c1.insertInDatabase(new Student(5, "Tom", 22));
			
			c1.insertInDatabase(new Student(6, "Aarav", 96));
			c1.insertInDatabase(new Student(7, "Sara", 16));
			c1.insertInDatabase(new Student(8, "Austin", 34));
			c1.insertInDatabase(new Student(9, "Rob", 57));
			c1.insertInDatabase(new Student(10, "Neel", 80)); */
			
			// Update student Tom
			
			// c1.updateInDatabase(5, 25);
			
			// Delete records if marks less than 35
			// c1.deleteFromDatabase(35);
			
			c1.displayAllRecords();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
	private Integer insertInDatabase(Student s) throws HibernateException {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		Integer stid = (Integer)session.save(s);
		System.out.println("Data inserted.");
		tx.commit();
		session.close();
		return stid;
	}
	
	private void updateInDatabase(Integer id, Integer marks) throws HibernateException {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Student st = (Student)session.get(Student.class, id);
		st.setMarks(marks);
		session.update(st);
		System.out.println("Data updated.");
		tx.commit();
		session.close();
	}

	private void deleteFromDatabase(Integer marks) throws HibernateException {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete Student where marks < :marks");
		query.setParameter("marks", marks);
		int result = query.executeUpdate();
		if(result > 0){
			System.out.println("Record deleted");
		}
		tx.commit();
		session.close();
	}
	
	private void displayAllRecords() throws HibernateException{
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		List list = session.createQuery("from Student").list();
		Iterator it = list.iterator();
		while(it.hasNext()){
			Student s = (Student) it.next();
			System.out.println("Student id : " + s.getId() + " name: " + s.getName() + " marks: " + s.getMarks());
		}
		tx.commit();
		session.close();
		
	}
}
