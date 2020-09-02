package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SnapshotArray {
	Map<Integer, Integer> curr;
	List<Map<Integer, Integer>> list;
	
	public SnapshotArray(int length) {
		curr = new HashMap<>();
		list = new ArrayList<>();
	}
	
	public void set(int indx, int val) {
		curr.put(indx, val);
	}
	
	public int snap() {
		Map<Integer, Integer> newMap = new HashMap<>();
		list.add(newMap);
		return list.size() - 1;
	}
	
	public int get(int indx, int snap_id) {
		return list.get(snap_id).getOrDefault(indx, 0);
	}
}

public class SnapshotArrayLeetcode1146 {

	public static void main(String[] args) {
		SnapshotArray obj = new SnapshotArray(3);
		obj.set(0, 5);
		System.out.println(obj.snap());
		obj.set(0, 6);
		System.out.println(obj.get(0, 0));
	}

}
