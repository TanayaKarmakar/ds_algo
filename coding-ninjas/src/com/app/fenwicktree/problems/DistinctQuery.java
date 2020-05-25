package com.app.fenwicktree.problems;

import java.util.Arrays;
import java.util.Scanner;

class Event implements Comparable<Event> {
	int first;
	int second;
	int indx;
	
	@Override
	public int compareTo(Event o) {
		return this.second - o.second;
	}	
}

public class DistinctQuery {
	
	private static void update(int[] bit, int indx, int val, int n) {
		for(;indx <= n; indx +=(indx & (-indx))) {
			bit[indx] += val;
		}
	}
	
	private static int query(int[] bit, int indx) {
		int count = 0;
		for(;indx > 0; indx -= (indx & (-indx))) {
			count += bit[indx];
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] nums = new int[n + 1];
		nums[0] = Integer.MAX_VALUE;
		
		for(int i = 1; i <= n; i++) {
			nums[i] = scanner.nextInt();
		}
		
		int q = scanner.nextInt();
		Event[] events = new Event[q];
		
		for(int i = 0; i < q; i++) {
			events[i] = new Event();
			events[i].first = scanner.nextInt();
			events[i].second = scanner.nextInt();
			events[i].indx = i;
		}
		
		Arrays.sort(events);
		
		int[] bit = new int[n + 1];
		int[] ans = new int[q];
		int[] last = new int[1000001];
		
		Arrays.fill(last, -1);
		
		int total = 0;
		int k = 0;
		
		for(int i = 1; i <= n; i++) {
			if(last[nums[i]] != -1) {
				update(bit, last[nums[i]], -1, n);
			} else {
				total++;
			}
			update(bit, i, 1, n);
			last[nums[i]] = i;
			while(k < q && events[k].second == i) {
				ans[events[k].indx] = total - 
						query(bit, events[k].first - 1);
				k++;
			}
		}
		
		for(int i = 0; i < q; i++) {
			System.out.println(ans[i]);
		}
		scanner.close();
	}

}
