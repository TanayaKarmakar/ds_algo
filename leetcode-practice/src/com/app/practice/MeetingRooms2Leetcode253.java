package com.app.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2Leetcode253 {
	private static int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (e1, e2) -> (e1[0] - e2[0]));

		Comparator<int[]> finishTimeComparator = (e1, e2) -> (e1[1] - e2[1]);
		PriorityQueue<int[]> pQ = new PriorityQueue<>(finishTimeComparator);

		int n = intervals.length;

		for (int i = 0; i < n; i++) {
			if (pQ.isEmpty() || pQ.peek()[1] > intervals[i][0]) {
				pQ.add(intervals[i]);
			} else {
				int[] existing = pQ.poll();
				existing[1] = intervals[i][1];
				pQ.add(existing);
			}
		}
		return pQ.size();
	}

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int minNumberOfRooms = minMeetingRooms(intervals);

		System.out.println(minNumberOfRooms);

		intervals = new int[][] { { 7, 10 }, { 2, 4 } };
		
		minNumberOfRooms = minMeetingRooms(intervals);

		System.out.println(minNumberOfRooms);
	}

}
