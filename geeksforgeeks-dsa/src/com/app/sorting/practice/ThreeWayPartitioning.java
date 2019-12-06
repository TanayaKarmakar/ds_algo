package com.app.sorting.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeWayPartitioning {
	private static void partitionArray(ArrayList<Integer> numbers, int a, int b) {
		int low = 0;
		int mid = 0;
		int high = numbers.size() - 1;
		
		while(mid <= high) {
			if(numbers.get(mid) < a) {
				swap(numbers, low, mid);
				mid++;
				low++;
			} else if(numbers.get(mid) >= a && numbers.get(mid) <= b) 
				mid++;
			else {
				swap(numbers, mid, high);
				high--;
			}
		}
	}
	
	private static void swap(ArrayList<Integer> numbers, int indx1, int indx2) {
		int tmp = numbers.get(indx1);
		numbers.set(indx1, numbers.get(indx2));
		numbers.set(indx2, tmp);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(3);
		numbers.add(4);
		
		partitionArray(numbers,1,2);
		
		System.out.println(numbers);

	}

}
