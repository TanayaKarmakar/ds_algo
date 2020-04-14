package com.app.greedy.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Activity implements Comparable<Activity> {
	int startTime;
	int endTime;

	@Override
	public int compareTo(Activity o) {
		return this.endTime - o.endTime;
	}
}

public class ActivitySelectionProblem {
	private static int getMaxActivity(List<Activity> activities, int nDim) {
		Collections.sort(activities);

		int count = 1;
		int currentEndTime = activities.get(0).endTime;

		for (int i = 1; i < nDim; i++) {
			Activity currActivity = activities.get(i);
			if (currActivity.startTime >= currentEndTime) {
				count++;
				currentEndTime = currActivity.endTime;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = scanner.nextInt();
		int temp = nDim;

		List<Activity> activities = new ArrayList<>();
		while (temp > 0) {
			Activity activity = new Activity();
			activity.startTime = scanner.nextInt();
			activity.endTime = scanner.nextInt();
			activities.add(activity);
			temp--;
		}

		int count = getMaxActivity(activities, nDim);
		
		System.out.println(count);
		scanner.close();
	}

}
