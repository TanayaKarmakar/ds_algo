package com.array.ideserve;

public class MedianOfTwoSortedArrays {
	private static double medianOfTwoSortedArrays(int[] input1, int[] input2) {
		if (input1.length > input2.length)
			return medianOfTwoSortedArrays(input2, input1);
		int x = input1.length;
		int y = input2.length;

		int start = 0;
		int end = x;

		while (start <= end) {
			int partitionX = (start + end) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
			int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

			int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
			int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0)
					return ((double) Math.max(maxLeftX, maxLeftY) + Math.max(minRightX, minRightY)) / 2;
				else
					return (double)Math.max(maxLeftX, maxLeftY);
			} else if(maxLeftX > minRightY) {
				end = partitionX - 1;
			} else {
				start = partitionX + 1;
			}
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {
		int[] x = {1,3,8,9,15};
		int[] y = {7,11,18,19,21,25};
		
		System.out.println("Median - " + medianOfTwoSortedArrays(x,y));

	}

}
