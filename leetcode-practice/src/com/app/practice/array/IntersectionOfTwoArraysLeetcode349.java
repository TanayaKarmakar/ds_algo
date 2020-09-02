package com.app.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IntersectionOfTwoArraysLeetcode349 {
	private static int[] intersection(int[] nums1, int[] nums2) {
		if(nums1.length == 0 || nums2.length == 0)
			return new int[] {};
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int m = nums1.length;
		int n = nums2.length;
		
		int i = 0, j = 0;
		
		Set<Integer> set = new HashSet<>();
		
		while(i < m && j < n) {
			if(nums1[i] < nums2[j]) {
				i++;
			} else if(nums1[i] > nums2[j]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		
		int[] res = new int[set.size()];
		i = 0;
		for(Integer el: set) {
			res[i++] = el;
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int m = scanner.nextInt();
		int[] nums1 = new int[m];
		
		for(int i = 0; i < m; i++) {
			nums1[i] = scanner.nextInt();
		}
		
		int n = scanner.nextInt();
		int[] nums2 = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums2[i] = scanner.nextInt();
		}
		
		int[] res = intersection(nums1, nums2);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();
	}

}
