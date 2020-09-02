package com.app.practice.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class FinishTimeComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		return o1[1] - o2[1];
	}

}

public class MeetingRoomsIILeetcode253 {
	private static int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (e1, e2) -> e1[0] - e2[0]);

		PriorityQueue<int[]> pQ = new PriorityQueue<>(new FinishTimeComparator());

		pQ.add(intervals[0]);

		int n = intervals.length;

		for (int i = 1; i < n; i++) {
			int[] curr = intervals[i];
			if (pQ.isEmpty() || pQ.peek()[1] > curr[0]) {
				pQ.add(curr);
			} else {
				int[] existing = pQ.poll();
				existing[1] = curr[1];
				pQ.add(existing);
			}
		}

		return pQ.size();
	}

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(minMeetingRooms(intervals));

		intervals = new int[][] { { 7, 10 }, { 2, 4 } };
		
		System.out.println(minMeetingRooms(intervals));
	}

}
