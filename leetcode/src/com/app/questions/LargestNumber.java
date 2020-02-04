package com.app.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class IntComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		String str1 = String.valueOf(o1);
		String str2 = String.valueOf(o2);
		
		String xy = str1 + str2;
		String yx = str2 + str1;
		return xy.compareTo(yx) > 0 ? -1:1;
	}
}

public class LargestNumber {
	private static String largestNumber(int[] nums) {
		return Arrays.stream(nums)
				.mapToObj(String::valueOf)
				.sorted((a, b) -> (b + a).compareTo(a + b))
				.collect(Collectors.joining())
				.replaceFirst("^0+", "0");
	}

	public static void main(String[] args) {
		System.out.println(largestNumber(new int[] { 10, 2 }));

		System.out.println(largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		
		System.out.println(largestNumber(new int[] { 128, 12 }));
		
		System.out.println(largestNumber(new int[] { 12, 121 }));
		
		System.out.println(largestNumber(new int[] { 0, 0 }));
	}

}
