package com.app.greedy.problems;

import java.util.Arrays;
import java.util.Scanner;

class Job implements Comparable<Job> {
	int startTime;
	int finishTime;
	int profit;
	
	@Override
	public int compareTo(Job o) {
		return this.finishTime - o.finishTime;
	}
	
	public String toString() {
		return "StartTime : " + this.startTime + ", EndTime : " + this.finishTime;
	}
}

public class WeightedJobScheduling {
	private static int getNonConflictingTaskIndx(Job[] jobs, int start, int end, int targetStartTime) {
		int ans = -1;
		int n = jobs.length;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(mid + 1 < n && jobs[mid].finishTime <= targetStartTime
					&& jobs[mid + 1].finishTime > targetStartTime)
				return mid;
			else if(mid - 1 >= 0 && jobs[mid - 1].finishTime <= targetStartTime
					&& jobs[mid].finishTime > targetStartTime)
				return mid - 1;
			else if(jobs[mid].finishTime > targetStartTime)
				end = mid - 1;
			else {
				ans = mid;
				start = mid + 1;
			}
		}
		return ans;
	}
	
	private static int getMaxProfit(Job[] jobs, int n) {
		Arrays.sort(jobs);
		
		System.out.println(Arrays.toString(jobs));
		int[] dp = new int[n];
		
		dp[0] = jobs[0].profit;
		for(int i = 1; i < n; i++) {
			int nConflictingTaskIndx = getNonConflictingTaskIndx(jobs, 0, i - 1, jobs[i].startTime);
			int profit = 0;
			if(nConflictingTaskIndx != -1) {
				profit = jobs[i].profit + dp[nConflictingTaskIndx];
			}
			
//			for(int j = i - 1; j >= 0; j--) {
//				if(jobs[i].startTime >= jobs[j].finishTime) {
//					profit = jobs[i].profit + dp[j];
//					break;
//				}
//			}
			if(profit != 0) {
				dp[i] = Integer.max(dp[i - 1], profit);
			} else {
				dp[i] = dp[i - 1];
			}
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nJobs = scanner.nextInt();
		Job[] jobs = new Job[nJobs];
		for(int i = 0; i < nJobs; i++) {
			Job job = new Job();
			job.startTime = scanner.nextInt();
			job.finishTime = scanner.nextInt();
			job.profit = scanner.nextInt();
			jobs[i] = job;
		}
		
		int maxProfit = getMaxProfit(jobs, nJobs);
		System.out.println(maxProfit);
		scanner.close();
	}
}
