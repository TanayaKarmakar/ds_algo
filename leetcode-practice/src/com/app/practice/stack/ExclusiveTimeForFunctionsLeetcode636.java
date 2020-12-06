package com.app.practice.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class StackNode {
	int id;
	String name;
	int timeStamp;

	public StackNode(int id, String name, int timeStamp) {
		this.id = id;
		this.name = name;
		this.timeStamp = timeStamp;
	}
}

public class ExclusiveTimeForFunctionsLeetcode636 {
	private static int[] exclusiveTime(int n, List<String> logs) {
		Stack<StackNode> stack = new Stack<>();
		int prev = 0;
		int timeElapsed = 0;

		TreeMap<Integer, Integer> tMap = new TreeMap<>();

		for (String log : logs) {
			String[] fragment = log.split(":");
			int id = Integer.parseInt(fragment[0]);
			String name = fragment[1];
			int timeStamp = Integer.parseInt(fragment[2]);

			if (name.equals("end")) {
				timeStamp++;
				stack.pop();
				timeElapsed = timeStamp - prev;
				tMap.put(id, tMap.getOrDefault(id, 0) + timeElapsed);
			} else {
				if (!stack.isEmpty()) {
					timeElapsed = timeStamp - prev;
					tMap.put(stack.peek().id, tMap.getOrDefault(stack.peek().id, 0) + timeElapsed);
				}
				stack.push(new StackNode(id, name, timeStamp));
			}
			prev = timeStamp;
		}

		int[] res = new int[n];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : tMap.entrySet()) {
			res[i++] = entry.getValue();
		}

		return res;

	}

	public static void main(String[] args) {
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");
		
		int[] res = exclusiveTime(2, logs);
		
		System.out.println(Arrays.toString(res));
	}

}
