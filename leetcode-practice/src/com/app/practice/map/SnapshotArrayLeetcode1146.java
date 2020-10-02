package com.app.practice.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SnapshotArray {
	Map<Integer, Integer> map;
	List<Map<Integer, Integer>> list;

	public SnapshotArray(int length) {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public void set(int index, int val) {
		map.put(index, val);
	}

	public int snap() {
		Map<Integer, Integer> newMap = new HashMap<>(map);
		list.add(newMap);
		return list.size() - 1;
	}

	public int get(int index, int snap_id) {
		return list.get(snap_id).getOrDefault(index, 0);
	}
}

public class SnapshotArrayLeetcode1146 {

	public static void main(String[] args) {
		SnapshotArray arr = new SnapshotArray(3);
		arr.set(0, 5);
		System.out.println(arr.snap());

		arr.set(0, 6);
		arr.get(0, 0);
	}

}
