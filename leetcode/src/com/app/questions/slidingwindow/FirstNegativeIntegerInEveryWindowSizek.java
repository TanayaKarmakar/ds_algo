package com.app.questions.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstNegativeIntegerInEveryWindowSizek {
	
	private static void firstNegativeNumber(int[] nums, int k) {
		int n = nums.length;
		int r = 0;
		
		Deque<Integer> dQ = new LinkedList<>();
		while(r < k) {
			if(nums[r] < 0) {
				dQ.add(r);
			}
			r++;
		}
		
		while(r < n) {
			if(dQ.isEmpty()) {
				System.out.print(0 + " ");
			} else {
				System.out.print(nums[dQ.peek()] + " ");
			}
			
			if(nums[r] < 0) {
				dQ.add(r);
			}
			while(!dQ.isEmpty() && dQ.peek() < (r - k + 1)) {
				dQ.poll();
			}
			r++;
		}
		if(dQ.isEmpty()) {
			System.out.print(0 + " ");
		} else {
			System.out.print(nums[dQ.peek()] + " ");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt();
			}
			int k = scanner.nextInt();
			firstNegativeNumber(nums, k);
			System.out.println();
		}
		scanner.close();
	}

}
