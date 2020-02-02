package com.app.heap.classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet> {
	int val;
	int aPos;
	int vPos;

	public Triplet(int val, int aPos, int vPos) {
		this.val = val;
		this.aPos = aPos;
		this.vPos = vPos;
	}

	@Override
	public int compareTo(Triplet o) {
		if (this.val == o.val)
			return 0;
		else if (this.val < o.val)
			return -1;
		else
			return 1;
	}

}

public class MergeKSortedArray {
	private static List<Integer> mergeKSortedArray(List<List<Integer>> arr) {
		int aSize = arr.size();
		List<Integer> res = new ArrayList<>();
		PriorityQueue<Triplet> pQ = new PriorityQueue<>();
		for (int i = 0; i < aSize; i++) {
			pQ.add(new Triplet(arr.get(i).get(0), i, 0));
		}

		while (!pQ.isEmpty()) {
			Triplet triplet = pQ.poll();
			int aPos = triplet.aPos;
			int vPos = triplet.vPos;
			int val = triplet.val;

			res.add(val);
			if (vPos + 1 < arr.get(aPos).size()) {
				pQ.add(new Triplet(arr.get(aPos).get(vPos + 1), aPos, vPos + 1));
			}
		}

		return res;
	}

	public static void main(String[] args) {
		List<List<Integer>> arr = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		curr.add(10);
		curr.add(20);
		arr.add(curr);
		
		curr = new ArrayList<>();
		curr.add(5);
		curr.add(15);
		arr.add(curr);
		
		curr = new ArrayList<>();
		curr.add(4);
		curr.add(9);
		curr.add(11);
		arr.add(curr);
		
		List<Integer> res = mergeKSortedArray(arr);
		System.out.println(res);
		
	}

}
