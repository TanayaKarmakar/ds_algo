package com.app.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class FinishTimeComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] o1, int[] o2) {
		return (o1[1] - o2[1]);
	}

}

public class MeetingRooms2Leetcode253 {
	private static int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (e1, e2) -> (e1[0] - e2[0]));

		PriorityQueue<int[]> pQ = new PriorityQueue<>(new FinishTimeComparator());
		for (int[] i : intervals) {
			if (pQ.isEmpty() || pQ.peek()[1] > i[0]) {
				pQ.add(i);
			} else {
				int[] existing = pQ.poll();
				existing[1] = i[1];
				pQ.add(existing);
			}
		}

		return pQ.size();
	}

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		int minMeetingRooms = minMeetingRooms(intervals);

		System.out.println(minMeetingRooms);

		intervals = new int[][] { { 7, 10 }, { 2, 4 } };
		
		minMeetingRooms = minMeetingRooms(intervals);

		System.out.println(minMeetingRooms);
	}

}
