package com.app.questions.stack;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollisionLeetcode735 {
	
	private static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < asteroids.length; i++) {
			if(stack.isEmpty() || asteroids[i] > 0) {
				stack.push(asteroids[i]);
			} else {
				while(true) {
					int peek = stack.peek();
					
					if(peek < 0) { //when stack peek is negative
						stack.push(asteroids[i]);
						break;
					} else if(peek == -asteroids[i]) { //when both magnitudes are equal
						stack.pop();
						break;
					} else if(peek > -asteroids[i]) { // when peek's magnitude is greater than new one
						break;
					} else {
						stack.pop();
						if(stack.isEmpty()) {
							stack.push(asteroids[i]);
							break;
						}
					}	
				}
			}
		}
		
		int[] result = new int[stack.size()];
		
		for(int i = stack.size() - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { -2, -2, 1, -1 };

		System.out.println(Arrays.toString(asteroidCollision(nums)));

		nums = new int[] { 8, -8 };

		System.out.println(Arrays.toString(asteroidCollision(nums)));

		nums = new int[] { 10, 2, -5 };
		
		System.out.println(Arrays.toString(asteroidCollision(nums)));
	}

}
