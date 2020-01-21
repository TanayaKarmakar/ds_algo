package com.app.queue.practice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseKElements {
	private static void revKElements(Queue<Integer> q, int k) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0;i<k;i++) {
			stack.push(q.remove());
		}
		
		while(!stack.isEmpty()) {
			q.add(stack.pop());
		}
		
		for(int i = 0; i < q.size() - k;i++) {
			q.add(q.remove());
		}
	}

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		q.add(60);
		
		revKElements(q, 3);
		
		Iterator<Integer> qItr = q.iterator();
		
		
		while(qItr.hasNext()) {
			System.out.print(qItr.next() + " ");
		}
		
		System.out.println();
	}
}
