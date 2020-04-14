package com.app.greedy.problems;

import java.util.Scanner;

public class SaveEnergy {
	private static int findMinimumEnergy(int[] towns, int n) {
		int curr = 0;
		int next = 0;
		int ans = 0;
		while(curr < n - 1) {
			next = curr + 1;
			while(next < n - 1) {
				if(Math.abs(towns[curr]) >= Math.abs(towns[next])
						|| (Math.abs(towns[curr]) == Math.abs(towns[next]) 
						&& Math.abs(towns[curr]) > 0)) {
					break;
				}
				next++;
			}
			
			ans += (next - curr) * towns[curr] 
					+ (next*next - curr*curr) * towns[curr] * towns[curr];
			curr = next;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTown = scanner.nextInt();
		
		int[] towns = new int[nTown];
		
		for(int i = 0; i < nTown; i++) {
			towns[i] = scanner.nextInt();
		}

		int ans = findMinimumEnergy(towns, nTown);
		
		System.out.println(ans);
		scanner.close();
	}

}
