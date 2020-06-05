package com.app.fenwicktree.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Pair {
	char first;
	int second;
	
	public Pair(char first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class OrderSetProblem {
	private static int[] bit;
	private static int[] arr;
	private static Map<Integer, Integer> map;
	
	private static int query(int indx) {
		int sum = 0;
		for(;indx > 0; indx -=(indx & (-indx))) {
			sum += bit[indx];
		}
		return sum;
	}
	
	private static void insert(int indx, int val, int n) {
		for(;indx <= n; indx += (indx & (-indx))) {
			bit[indx] += val;
		}
	}
	
	private static int lowerBound(int start, int end, int val) {
		while(start < end) {
			int mid = (start + end) >> 1;
			if(arr[mid] >= val)
				end = mid;
			else
				start = mid + 1;
		}
		return start;
	}
	
	private static int search(int start, int end, int el) {
		int ans = arr.length;
		while(start <= end) {
			int mid = (start + end) >> 1;
			if(query(map.get(arr[mid])) >= el) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int i = 0;
		List<Pair> input = new ArrayList<>();
		while(i < n) {
			char first = scanner.next().charAt(0);
			int second = scanner.nextInt();
			Pair pair = new Pair(first, second);
			input.add(pair);
			i++;
		}
		
		map = new HashMap<>();
		for(Pair pair: input) {
			int num = pair.second;
			map.put(num, 1);
		}
		
		arr = new int[map.size()];
		i = 0;
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			arr[i++] = entry.getKey();
		}
		
		for(i = 0; i < arr.length; i++) {
			map.put(arr[i], 1 + i);
		}
		
		Arrays.sort(arr);
		bit = new int[n + 1];
		
		for(Pair pair: input) {
			char first = pair.first;
			if(first == 'I') {
				int indx = map.get(pair.second);
				if(query(indx) == query(indx - 1))
					insert(indx, 1, n);
			} else if(first == 'D') {
				int indx = map.get(pair.second);
				if(query(indx) != query(indx - 1))
					insert(indx, -1, n);
				
			} else if(first == 'K') {
				int val = search(0, arr.length - 1, pair.second);
				if(val == arr.length) {
					System.out.println("Invalid");
				} else {
					System.out.println(arr[val]);
				}
				
			} else {
				int j = lowerBound(0, arr.length - 1, pair.second);
				j--;
				if(j < 0) {
					System.out.println(0);
				} else {
					System.out.println(query(map.get(arr[j])));
				}
			}
		}
		
		scanner.close();
	}

}
