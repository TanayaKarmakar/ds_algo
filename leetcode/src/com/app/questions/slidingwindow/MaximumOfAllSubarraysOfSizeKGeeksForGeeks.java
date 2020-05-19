package com.app.questions.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaximumOfAllSubarraysOfSizeKGeeksForGeeks {
	private static void maxOfAllSubarray(int[] nums, int k) {
		int n = nums.length;
		Deque<Integer> maxD = new LinkedList<>();
		int r = 0;
		for(r = 0; r < k; r++) {
			while(!maxD.isEmpty() && nums[maxD.peekLast()] < nums[r]) {
				maxD.removeLast();
			}
			maxD.addLast(r);
		}
		
		while(r < n) {
			System.out.print(nums[maxD.peek()] + " ");
			
			while(!maxD.isEmpty() && maxD.peek() < (r - k + 1)) {
				maxD.remove();
			}
			
			while(!maxD.isEmpty() && nums[maxD.peekLast()] < nums[r]) {
				maxD.removeLast();
			}
			maxD.addLast(r);
			
			
			r++;
		}
		System.out.print(nums[maxD.peek()] + " ");
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			
			maxOfAllSubarray(nums, k);
			System.out.println();
		}
		scanner.close();
	}

}
