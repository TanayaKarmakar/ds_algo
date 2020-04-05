package com.app.dp2.problems;

import java.util.Arrays;
import java.util.Scanner;

public class CharlieAndPilotTopDown {
	private static int getMinimumSalaryHelper(int[][] dp, int[] captains, int[] assistants, 
			int currentIndx, int diff, int total) {
		if(currentIndx >= 2 * total)
			return 0;
		if(dp[currentIndx][total] == Integer.MAX_VALUE) {
			int option1 = Integer.MAX_VALUE;
			int option2 = Integer.MAX_VALUE;
			
			if(diff == 0) {
				option1 = assistants[currentIndx] + getMinimumSalaryHelper(dp, captains, assistants, currentIndx + 1, 1, total);
			}
			else if(diff == total) {
				option2 = captains[currentIndx] + getMinimumSalaryHelper(dp,captains, assistants, currentIndx + 1, diff - 1, total);
			} else {
				option1 = assistants[currentIndx]
						+ getMinimumSalaryHelper(dp, captains, assistants, currentIndx + 1, diff + 1, total);
				
				option2 = captains[currentIndx]
						+ getMinimumSalaryHelper(dp, captains, assistants, currentIndx + 1, diff - 1, total);
			}
			dp[currentIndx][total] = Integer.min(option1, option2);
		}
		return dp[currentIndx][total];
	}

	private static int getMinimumSalary(int[] captains, int[] assistants, int nDim) {
		int[][] dp = new int[nDim][nDim / 2 + 1];
		for(int i = 0; i < nDim; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = assistants[0];

		return getMinimumSalaryHelper(dp, captains, assistants, 0, 1, nDim / 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int nDim = scanner.nextInt();

		int[] captains = new int[nDim];
		int[] assistants = new int[nDim];

		for (int i = 0; i < nDim; i++) {
			captains[i] = scanner.nextInt();
			assistants[i] = scanner.nextInt();
		}

		int minSalary = getMinimumSalary(captains, assistants, nDim);

		System.out.println(minSalary);

		scanner.close();

	}

}
