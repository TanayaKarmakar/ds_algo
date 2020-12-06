package com.app.stack;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class SunsetView {
	private static List<Integer> getBuildings(int[] buildings) {
		Stack<Integer> stack = new Stack<>();

		int n = buildings.length;

		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= buildings[i])
				stack.pop();
			stack.push(buildings[i]);
		}

		List<Integer> result = stack.stream().collect(Collectors.toList());

		return result;
	}

	public static void main(String[] args) {
		int[] buildings = { 4, 1, 5, 2, 8, 5, 7 };

		List<Integer> result = getBuildings(buildings);

		System.out.println(result);

	}

}
