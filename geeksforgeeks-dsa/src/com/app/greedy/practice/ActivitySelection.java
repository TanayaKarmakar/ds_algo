package com.app.greedy.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Activity implements Comparable<Activity> {
	int startTime;
	int finishTime;

	public Activity(int startTime, int finishTime) {
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	@Override
	public int compareTo(Activity that) {
		if (this.finishTime < that.finishTime)
			return -1;
		else if (this.finishTime > that.finishTime)
			return 1;
		else
			return 0;
	}

}

public class ActivitySelection {
	private static int activitySelection(int[] start, int[] end, int n) {
		List<Activity> activities = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			activities.add(new Activity(start[i], end[i]));
		}
		Collections.sort(activities);

		int activityCount = 1;
		int currentFinishTime = activities.get(0).finishTime;
		for (int i = 1; i < activities.size(); i++) {
			Activity nextActivity = activities.get(i);
			if (nextActivity.startTime >= currentFinishTime) {
				activityCount++;
				currentFinishTime = nextActivity.finishTime;
			}
		}

		return activityCount;
	}

	public static void main(String[] args) {
		int[] start = { 1, 3, 2, 5, 8, 5 };
		int[] end = { 2, 4, 6, 7, 9, 9 };

		System.out.println("ActivityCount - " + activitySelection(start, end, start.length));

		start = new int[] { 1, 3, 2, 5 };
		end = new int[] { 2, 4, 3, 6 };
		
		System.out.println("ActivityCount - " + activitySelection(start, end, start.length));
	}

}
