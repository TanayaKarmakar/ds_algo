package com.app.fenwicktree.problems;

import java.util.Arrays;
import java.util.Scanner;

class Coder implements Comparable<Coder> {
	int x;
	int y;
	int index;
	
	@Override
	public int compareTo(Coder o) {
		if(this.x == o.x)
			return (this.y - o.y);
		return (this.x - o.x);
	}	
}

public class CodersRating {
	
	private static void update(int indx, int[] bit) {
		for(int i = indx; i < 100001; i += (i & (-i))) {
			bit[i]++;
		}
	}
	
	private static int query(int indx, int[] bit) {
		int count = 0;
		for(int i = indx; i > 0; i -= (i & (-i)))
			count += bit[i];
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Coder[] coders = new Coder[n];
		
		
		for(int i = 0; i < n; i++) {
			coders[i] = new Coder();
			coders[i].x = scanner.nextInt();
			coders[i].y = scanner.nextInt();
			coders[i].index = i;
		}
		
		Arrays.sort(coders);
		
		int[] bit = new int[100001];
		int[] ans = new int[n];
		
		for(int i = 0; i < n;) {
			int endIndx = i;
			while(endIndx < n && coders[i].x == coders[endIndx].x
					&& coders[i].y == coders[endIndx].y) {
				endIndx++;
			}
			for(int j = i; j < endIndx; j++) {
				ans[coders[j].index] = query(coders[j].y, bit);
			}
			
			for(int j = i; j < endIndx; j++) {
				update(coders[j].y, bit);
			}
			
			i = endIndx;
		}
		
		for(int i = 0; i < n; i++) {
			System.out.println(ans[i]);
		}

		scanner.close();
	}

}
