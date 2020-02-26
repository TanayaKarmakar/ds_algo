package com.app.greedy.classroom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Job implements Comparable<Job> {
	int slot;
	int profit;

	public Job(int slot, int profit) {
		this.slot = slot;
		this.profit = profit;
	}

	@Override
	public int compareTo(Job o) {
		if (this.profit < o.profit)
			return 1;
		else if (this.profit > o.profit)
			return -1;
		else
			return 0;
	}

}

public class JobSequencingProblem {
	private static int checkFirstAvailableSlot(int[] slots, int slotNum) {
		for (int i = slotNum - 1; i >= 0; i--) {
			if(slots[i] == -1)
				return i;
				
		}
		return Integer.MAX_VALUE;
	}

	private static int findMaxProfit(List<Job> jobs) {
		Collections.sort(jobs);

		int[] slots = new int[jobs.size()];
		Arrays.fill(slots, -1);
		int profit = 0;
		for (int i = 0; i < jobs.size(); i++) {
			Job job = jobs.get(i);
			if (slots[job.slot - 1] == -1) {
				slots[job.slot - 1] = job.slot;
				profit += job.profit;
			} else {
				int slotIndx = checkFirstAvailableSlot(slots, job.slot);
				if(slotIndx != Integer.MAX_VALUE) {
					slots[slotIndx] = job.slot;
					profit += job.profit;
				}
					
			}
		}

		return profit;
	}

	public static void main(String[] args) {
		List<Job> profits = new ArrayList<>();

		profits.add(new Job(4, 50));
		profits.add(new Job(1, 5));
		profits.add(new Job(1, 20));
		profits.add(new Job(5, 10));
		profits.add(new Job(5, 80));

		System.out.println("Profit - " + findMaxProfit(profits));
		
		profits = new ArrayList<>();
		profits.add(new Job(9, 15));
		profits.add(new Job(2, 2));
		profits.add(new Job(5, 18));
		profits.add(new Job(7, 1));
		profits.add(new Job(4, 25));
		profits.add(new Job(2, 20));
		profits.add(new Job(5, 8));
		profits.add(new Job(7, 10));
		profits.add(new Job(4, 12));
		profits.add(new Job(3, 5));
		
		System.out.println("Profit - " + findMaxProfit(profits));

	}

}
