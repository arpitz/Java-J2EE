/* Write a program to define a queue interface and have insert and delete 
 * methods in the interface. 
 * Implement these methods in a class. */

package com.edureka.module4Interface;

import java.util.Scanner;

public class QueueAssign implements QueueInterface {
	
	int arr[] = new int[10];
	int front = 0;
	int rear = 0;

	public static void main(String[] args) {
		System.out.println("Enter four numbers in the queue");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		QueueAssign q1 = new QueueAssign();
		q1.insert(x);
		x = sc.nextInt();
		q1.insert(x);
		x = sc.nextInt();
		q1.insert(x);
		x = sc.nextInt();
		q1.insert(x);
		sc.close();
		System.out.println("The numbers in queue after insertion are : ");
		q1.display();
		System.out.println("After removing 2 elements from queue, the new queue is : ");
		q1.delete();
		q1.delete();
		q1.display();
	}
	
	public void display() {
		for(int i = front; i < rear; i++){
			System.out.println(arr[i]);
		}
	}

	@Override
	public void insert(int n) {
		arr[rear] = n;
		rear++;
	}

	@Override
	public int delete() {
		return arr[front++];
	}

}
