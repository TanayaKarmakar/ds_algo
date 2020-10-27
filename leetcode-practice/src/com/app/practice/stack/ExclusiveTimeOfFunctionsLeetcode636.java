package com.app.practice.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class StackNode {
	int id;
	String name;
	int startTime;

	public StackNode(int id, String name, int startTime) {
		this.id = id;
		this.name = name;
		this.startTime = startTime;
	}
	
	public String toString() {
		return "ID : " + id + ", Name : " + name + ", StartTime : " + startTime;
	}
}

public class ExclusiveTimeOfFunctionsLeetcode636 {

	private static int[] exclusiveTime(int n, List<String> logs) {
		Stack<StackNode> stack = new Stack<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int prev = 0;

		for (String str : logs) {
			String[] arr = str.split(":");
			int id = Integer.parseInt(arr[0]);
			String name = arr[1];
			int timeStamp = Integer.parseInt(arr[2]);

			if (name.equals("end")) {
				stack.pop();
				timeStamp++;
				int timeElapsed = (timeStamp - prev);
				map.put(id, map.getOrDefault(id, 0) + timeElapsed);
			} else {
				if (!stack.isEmpty()) {
					int timeElapsed = (timeStamp - prev);
					map.put(stack.peek().id, map.getOrDefault(stack.peek().id, 0) + timeElapsed);
				}
				stack.push(new StackNode(id, name, timeStamp));
			}
			prev = timeStamp;
		}

		System.out.println(map);
		int[] res = new int[n];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			res[i++] = entry.getValue();
		}

		return res;
	}

	public static void main(String[] args) {
		List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
		int n = 2;

		int[] res = exclusiveTime(n, logs);

		System.out.println(Arrays.toString(res));

	}

}
