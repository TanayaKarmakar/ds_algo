package com.app.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray {
	private Map<Integer, Integer> curr;
	private List<Map<Integer, Integer>> list;
	
	public SnapshotArray(int length) {
		curr = new HashMap<Integer, Integer>(length);
		list = new ArrayList<>();
	}
	
	public void set(int indx, int val) {
		curr.put(indx, val);
	}
	
	public int snap() {
		Map<Integer, Integer> n = new HashMap<>(curr);
		list.add(n);
		return list.size() - 1;
	}
	
	public int get(int indx, int snap) {
		return list.get(snap).getOrDefault(indx, 0);
	}

	public static void main(String[] args) {
		SnapshotArray obj = new SnapshotArray(3);
		obj.set(0, 5);
		System.out.println(obj.snap());
		obj.set(0, 6);
		System.out.println(obj.get(0, 0));
		
		obj = new SnapshotArray(1);
		obj.set(0, 4);
		obj.set(0, 16);
		obj.set(0, 13);
		System.out.println(obj.snap());
		System.out.println(obj.get(0, 0));
		System.out.println(obj.snap());
	}

}
