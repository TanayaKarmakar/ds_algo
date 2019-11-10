package com.app.bitmagic.practice;

public class LongestConsecutive1 {
	private static int longestConsqcutiveOnesAlternateSolution(int num) {
		int count = 0;
		while(num != 0) {
			num = num & (num << 1);
			count++;
		}
		
		return count;
	}
	
	private static int longestConsecutiveOnes(int num) {
		if(num == 0)
			return 0;
		int currentCount = 0;
		int maxCount = 0;
		
		while(num > 0) {
			if((num & 1) == 1) {
				currentCount++;
				if(currentCount > maxCount) {
					maxCount = currentCount;
				}
			} else {
				currentCount = 0;
			}
			num = num >> 1;
		}
		return maxCount;
	}

	public static void main(String[] args) {
		System.out.println("Longest common 1s - " + longestConsecutiveOnes(14));
		
		System.out.println("Longest common 1s - " + longestConsecutiveOnes(222));
		
		System.out.println("Longest common 1s - " + longestConsqcutiveOnesAlternateSolution(14));
		
		System.out.println("Longest common 1s - " + longestConsqcutiveOnesAlternateSolution(222));
	}

}
