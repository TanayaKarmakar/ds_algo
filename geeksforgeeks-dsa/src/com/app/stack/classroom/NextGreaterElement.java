package com.app.stack.classroom;

import java.util.Stack;

public class NextGreaterElement {
	private static void nextGreater(int[] arr) {
		int n = arr.length;
		String str = " ";

		Stack<Integer> stack = new Stack<>();
		stack.push(arr[n - 1]);
		str  = "-1 " + str;
		//System.out.print(-1 + " ");

		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() < arr[i]) {
				stack.pop();
			}

			int nextGreater = stack.isEmpty() ? -1 : stack.peek();
			stack.push(arr[i]);
			//System.out.print(nextGreater + " ");
			str = nextGreater + " " + str;
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 15, 10, 8, 6, 12, 9, 18 };
		nextGreater(arr);
		
		arr = new int[] {10, 15, 20, 25};
		nextGreater(arr);
		
		arr = new int[] {25, 20, 15, 10};
		nextGreater(arr);
	}

}
