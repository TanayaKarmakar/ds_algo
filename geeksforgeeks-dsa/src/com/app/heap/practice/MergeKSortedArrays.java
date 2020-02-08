package com.app.heap.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Triplet implements Comparable<Triplet>{
	int data;
	int aPos;
	int vPos;

	public Triplet(int data, int aPos, int vPos) {
		this.data = data;
		this.aPos = aPos;
		this.vPos = vPos;
	}

	@Override
	public int compareTo(Triplet o) {
		if(this.data == o.data)
			return 0;
		else if(this.data < o.data)
			return -1;
		else
			return 1;
	}
}

public class MergeKSortedArrays {
	private static List<Integer> mergeKArrays(List<List<Integer>> nums) {
		PriorityQueue<Triplet> pQ = new PriorityQueue<>();

		for (int i = 0; i < nums.size(); i++) {
			pQ.add(new Triplet(nums.get(i).get(0), i, 0));
		}
		
		List<Integer> res = new ArrayList<>();
		
		while(!pQ.isEmpty()) {
			Triplet curr = pQ.poll();
			int aPos = curr.aPos;
			int vPos = curr.vPos;
			res.add(curr.data);
			if(vPos + 1 < nums.get(aPos).size()) {
				pQ.add(new Triplet(nums.get(aPos).get(vPos + 1), aPos, vPos + 1));
			}
		}
		return res;
	}

	public static void main(String[] args) {
		

	}

}
