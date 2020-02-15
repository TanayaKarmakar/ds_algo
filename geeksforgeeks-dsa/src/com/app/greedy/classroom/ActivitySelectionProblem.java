package com.app.greedy.classroom;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelectionProblem {
	private static int countMostActivity(List<List<Integer>> activities) {
		activities.sort((o1, o2) -> o1.get(1).compareTo(o2.get(1)));
		for(List<Integer> curr: activities) {
			System.out.println(curr);
		}
		
		List<List<Integer>> res = new ArrayList<>();
		res.add(activities.get(0));
		int count = res.size()  - 1;
		for(int i = 0;i<activities.size();i++) {
			List<Integer> current = res.get(count);
			if(i + 1< activities.size()) {
				if(current.get(1) <= activities.get(i + 1).get(0)) {
					res.add(activities.get(i + 1));
					count = res.size() - 1;
				}	
			}
		}
		
		for(List<Integer> curr: res) {
			System.out.println(curr);
		}
		
		return res.size();
	}

	public static void main(String[] args) {
		List<List<Integer>> activities = new ArrayList<>();
		List<Integer> item = new ArrayList<>();
		item.add(3);
		item.add(8);
		activities.add(item);
		
		item = new ArrayList<>();
		item.add(2);
		item.add(4);
		activities.add(item);
		
		item = new ArrayList<>();
		item.add(1);
		item.add(3);
		activities.add(item);
		
		item = new ArrayList<>();
		item.add(10);
		item.add(11);
		activities.add(item);
		
		System.out.println(countMostActivity(activities));

	}

}
