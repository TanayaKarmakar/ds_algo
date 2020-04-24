package com.app.questions.read;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SplitArrayIntoConsecutiveSubsequencesLeetcode659 {
	private static int getListPos(List<List<Integer>> lists, int item) {
		int listPos = 0;
		for (List<Integer> list : lists) {
			int lastItem = list.get(list.size() - 1);
			if (lastItem + 1 == item) {
				if(listPos + 1 < lists.size() && list.get(list.size() - 1) + 1 == item) {
					if(list.size() < 3)
						return listPos;
					else
						return listPos + 1;
				}
				return listPos;
			}
				
			listPos++;
		}
		return -1;
	}

	private static boolean isPossible(int[] nums) {
		if (nums.length < 3)
			return false;
		List<List<Integer>> lists = new ArrayList<>();
		int n = nums.length;

		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pQ.add(nums[i]);
		}
		
		System.out.println(pQ);

		while (!pQ.isEmpty()) {
			int item = pQ.poll();
			if (lists.isEmpty() || getListPos(lists, item) == -1) {
				List<Integer> list = new ArrayList<>();
				list.add(item);
				lists.add(list);
			} else {
				int listPos = getListPos(lists, item);
				lists.get(listPos).add(item);
			}
		}

		
		//System.out.println(lists);
		for (List<Integer> list : lists) {
			if (list.size() < 3)
				return false;
		}
		return true;
		/*
		 * if (nums.length < 3) return false; TreeMap<Integer, Integer> map = new
		 * TreeMap<>(); int n = nums.length;
		 * 
		 * for (int i = 0; i < n; i++) { if (!map.containsKey(nums[i])) {
		 * map.put(nums[i], 1); } else { map.put(nums[i], map.getOrDefault(nums[i], 0) +
		 * 1); } }
		 * 
		 * int size = n / 3; List[] lists = new ArrayList[size]; for (int i = 0; i <
		 * size; i++) { List<Integer> list = new ArrayList<>(); int firstKey =
		 * map.firstKey(); int endVal = firstKey + 3; endVal = (i == 0 ? endVal + (n %
		 * 3) : endVal); for (int j = firstKey; j < endVal; j++) { if
		 * (!map.containsKey(j)) return false; else { list.add(j); int c = map.get(j);
		 * if (c == 1) { map.remove(j); } else { map.put(j, --c); } } }
		 * 
		 * lists[i] = list; }
		 * 
		 * if (map.size() == 0) return true; else { while (map.size() > 0) { int
		 * firstKey = map.firstKey(); boolean added = false; for (List<Integer> list :
		 * lists) { int item = list.get(list.size() - 1); if (item + 1 == firstKey) {
		 * list.add(firstKey); added = true; // break; } map.remove(firstKey); } //
		 * if(!added) // return false; }
		 * 
		 * for (List<Integer> list : lists) { if (list.size() < 3) return false; } }
		 * 
		 * return true;
		 */
	}

	public static void main(String[] args) {
		// TC1
		int[] nums = { 1, 2, 3, 3, 4, 5 };

		System.out.println(isPossible(nums));

		// TC2
		nums = new int[] { 1, 2, 3, 3, 4, 4, 5, 5 };

		System.out.println(isPossible(nums));

		nums = new int[] { 10, 10, 10 };

		System.out.println(isPossible(nums));

		nums = new int[] { 1, 2, 3, 4, 4, 5 };

		System.out.println(isPossible(nums));

		nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		System.out.println(isPossible(nums));

		nums = new int[] { 4, 5, 6, 7, 7, 8, 8, 9, 10, 11 };

		System.out.println(isPossible(nums));
	}

}
