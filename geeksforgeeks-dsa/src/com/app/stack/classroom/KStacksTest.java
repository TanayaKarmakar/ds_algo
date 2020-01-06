package com.app.stack.classroom;

public class KStacksTest {

	public static void main(String[] args) {
		int k = 3;
		int n = 10;
		KStacks kStacks = new KStacks(k, n);
		
		kStacks.push(15, 2);
		kStacks.push(45, 2);
		kStacks.push(10, 0);
		kStacks.push(20, 0);
		kStacks.push(30, 0);
		kStacks.push(15, 1);
		kStacks.push(25, 1);
		
		System.out.println(kStacks.pop(2));
		System.out.println(kStacks.pop(1));
		System.out.println(kStacks.pop(0));

	}

}
