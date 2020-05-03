package com.app.questions.practice;

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
    
    public void set(int index, int val) {
       curr.put(index, val);
    }
    
    public int snap() {
       Map<Integer, Integer> n = new HashMap<>(curr);
       list.add(n);
       return list.size() - 1;
    }
    
    public int get(int index, int snap_id) {
       return list.get(snap_id).getOrDefault(index, 0);
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
