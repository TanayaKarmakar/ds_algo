package com.app.languagetools1.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class VisitedIndx {
	boolean visited;
	int indx;
	
	public VisitedIndx(int indx, boolean visited) {
		this.indx = indx;
		this.visited = visited;
	}
}

public class LongestConsecutiveIncreasingSubsequence {
	private static List<Integer> longestConsecutiveIncreasingSequence(int[] nums) {
		Map<Integer, VisitedIndx> visitedMap = new LinkedHashMap<>();
		Map<Integer, List<Integer>> sequenceMap = new LinkedHashMap<>();

		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if(!visitedMap.containsKey(nums[i])) {
				visitedMap.put(nums[i], new VisitedIndx(i, true));
			}
			
		}

		int i = 0;
		while (i < n) {
			int curr = nums[i];
			List<Integer> elements = new ArrayList<>();
			int tmp = curr;
			// traversing towards right of a number
			while (visitedMap.containsKey(tmp) && visitedMap.get(tmp).visited == true) {
				elements.add(tmp);
				//visitedMap.put(tmp, false);
				visitedMap.get(tmp).visited = false;
				tmp++;
			}

			// traversing towards left of a number
			tmp = curr - 1;
			while (visitedMap.containsKey(tmp) && visitedMap.get(tmp).visited == true) {
				elements.add(0, tmp);
				//visitedMap.put(tmp, false);
				visitedMap.get(tmp).visited = false;
				tmp--;
			}
			
			int start = (tmp != curr) ? (tmp + 1) : curr;

			if (!sequenceMap.containsKey(start)) {
				sequenceMap.put(start, elements);
			}
			i++;
		}

		int maxLen = Integer.MIN_VALUE;
		int maxLenIndxSoFar = -1;
		List<Integer> res = new ArrayList<>();
		for (Map.Entry<Integer, List<Integer>> entry : sequenceMap.entrySet()) {
			if(entry.getValue().size() == maxLen) {
				int currIndx = visitedMap.get(entry.getKey()).indx;
				if(currIndx < maxLenIndxSoFar) {
					maxLenIndxSoFar = currIndx;
					res = entry.getValue();
				}
			}
			if (entry.getValue().size() > maxLen) {
				maxLen = entry.getValue().size();
				res = entry.getValue();
				maxLenIndxSoFar = visitedMap.get(entry.getKey()).indx;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 7, 2, 1, 9, 8, 1 };

		System.out.println(longestConsecutiveIncreasingSequence(nums));

		nums = new int[] { 15, 24, 23, 12, 19, 11, 16 };

		System.out.println(longestConsecutiveIncreasingSequence(nums));

		nums = new int[] { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };

		System.out.println(longestConsecutiveIncreasingSequence(nums));

		nums = new int[] { 11, 13, 14, 5, 4, 12, 6, 8, 10, 7 };
		
		System.out.println(longestConsecutiveIncreasingSequence(nums));
		
		nums = new int[] {4, 3, 2, 6, 1, 7, 8, 9, 6};
		
		System.out.println(longestConsecutiveIncreasingSequence(nums));
	}

}
