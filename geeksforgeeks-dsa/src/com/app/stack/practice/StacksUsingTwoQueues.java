package com.app.stack.practice;

import java.util.LinkedList;
import java.util.Queue;


//here we are making push operation costly
public class StacksUsingTwoQueues {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	public void push(int data) {
		q2.add(data);
		
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}
	
	public int pop() {
		if(q1.isEmpty())
			return -1;
		return q1.remove();
	}

	public static void main(String[] args) {
		StacksUsingTwoQueues stack = new StacksUsingTwoQueues();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
