package com.app.greedy.practice;

import java.util.Arrays;
import java.util.Comparator;

class Job {
	int id;
	int profit;
	int deadline;

	public Job(int id, int deadline, int profit) {
		this.id = id;
		this.profit = profit;
		this.deadline = deadline;
	}
}

class JobComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		if (o1.profit < o2.profit)
			return 1;
		else if (o1.profit > o2.profit)
			return -1;
		else
			return 0;
	}

}

public class JobSequencingProblem {
	private static int findAvailableSlot(int[] slots, int deadline) {
		for (int i = slots.length - 1; i >= 0; i--) {
			if(slots[i] == -1)
				return i;
		}
		return -1;
	}

	private static void printScheduling(Job[] arr, int n) {
		Arrays.sort(arr, new JobComparator());
		int jobCount = 0;
		int totalProfit = 0;
		// int startDeadline = 1;

		int[] slots = new int[n];
		Arrays.fill(slots, -1);
		for (Job item : arr) {
			if (slots[item.deadline - 1] == -1) {
				slots[item.deadline - 1] = item.deadline;
				totalProfit += item.profit;
				jobCount++;
			} else {
				int slotIndx = findAvailableSlot(slots, item.deadline);
				if(slotIndx != -1) {
					slots[slotIndx] = item.deadline;
					totalProfit += item.profit;
					jobCount++;
				}	
			}
		}

		System.out.println(jobCount + " " + totalProfit);
	}

	public static void main(String[] args) {
		Job[] arr = new Job[4];
		arr[0] = new Job(1, 4, 20);
		arr[1] = new Job(2, 1, 10);
		arr[2] = new Job(3, 1, 40);
		arr[3] = new Job(4, 1, 30);

		printScheduling(arr, arr.length);

		arr = new Job[5];
		arr[0] = new Job(1, 2, 100);
		arr[1] = new Job(2, 1, 19);
		arr[2] = new Job(3, 2, 27);
		arr[3] = new Job(4, 1, 25);
		arr[4] = new Job(5, 1, 15);

		printScheduling(arr, arr.length);
	}

}
