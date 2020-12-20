package com.app.priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

enum SubarrayType {
	INCREASING,
	DECREASING;
}

class Node implements Comparable<Node> {
	List<Integer> list;
	int aPos;
	int vPos;
	
	public Node(List<Integer> list, int aPos, int vPos) {
		this.list = list;
		this.aPos = aPos;
		this.vPos = vPos;
	}

	@Override
	public int compareTo(Node o) {
		return this.list.get(this.vPos) - o.list.get(o.vPos);
	}
}

public class SortAnIncreasingDecreasingSubarray {
	private static List<Integer> mergeSortedArrays(List<List<Integer>> sortedSubarrays) {
		PriorityQueue<Node> pQ = new PriorityQueue<>();
		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < sortedSubarrays.size(); i++) {
			pQ.add(new Node(sortedSubarrays.get(i), i, 0));
		}
		
		while(!pQ.isEmpty()) {
			Node node = pQ.poll();
			int aPos = node.aPos;
			int vPos = node.vPos;
			result.add(node.list.get(vPos));
			if(vPos + 1 >= node.list.size())
				continue;
			pQ.add(new Node(node.list, aPos, vPos + 1));
		}
		
		return result;
	}
	
	private static List<Integer> sortAnIncreasingDecreasingSubarray(List<Integer> list) {
		if(list.size() <= 1)
			return list;
		List<List<Integer>> sortedSubarrays = new ArrayList<>();
		
		SubarrayType type = SubarrayType.INCREASING;
		int startIndx = 0;
		
		for(int i = 1; i <= list.size(); i++) {
			if(i == list.size() || (list.get(i - 1) < list.get(i) && type == SubarrayType.DECREASING)
					|| (list.get(i - 1) >= list.get(i) && type == SubarrayType.INCREASING)) {
				List<Integer> subList = list.subList(startIndx, i);
				startIndx = i;
				
				if(type == SubarrayType.DECREASING)
					Collections.reverse(subList);
				sortedSubarrays.add(subList);
				type = (type == SubarrayType.DECREASING ? SubarrayType.INCREASING : SubarrayType.DECREASING);
			}
		}
		
		return mergeSortedArrays(sortedSubarrays);
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(List.of(57, 131, 493, 294, 221, 339, 418, 452, 442, 190));
		
		List<Integer> result = sortAnIncreasingDecreasingSubarray(list);
		
		System.out.println(result);
	}

}
