package com.app.greedy.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MeetingTime implements Comparable<MeetingTime> {
	int startTime;
	int endTime;
	int indx;

	public MeetingTime(int startTime, int endTime, int indx) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.indx = indx;
	}

	@Override
	public int compareTo(MeetingTime that) {
		if (this.endTime < that.endTime)
			return -1;
		else if (this.endTime > that.endTime)
			return 1;
		else
			return 0;
	}
}

public class NMeetingsInOneRoom {

	private static void meetings(int[] start, int[] end, int n) {
		List<MeetingTime> meetings = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			meetings.add(new MeetingTime(start[i], end[i], i));
		}

		Collections.sort(meetings);

		System.out.print(meetings.get(0).indx + 1 + " ");
		int currentFinishTime = meetings.get(0).endTime;

		for (int i = 1; i < meetings.size(); i++) {
			MeetingTime nextMeeting = meetings.get(i);
			if(nextMeeting.startTime >= currentFinishTime) {
				System.out.print(nextMeeting.indx + 1 + " ");
				currentFinishTime = nextMeeting.endTime;
			}
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		int[] start = {1, 3, 0, 5, 8, 5};
		int[] end = {2, 4, 6, 7, 9, 9};
		
		meetings(start, end, start.length);
		
		start = new int[] {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
		end = new int[] {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
		
		meetings(start, end, start.length);

	}

}
