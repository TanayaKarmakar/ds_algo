package com.app.dp2.problems;

import java.util.Scanner;

public class CharlieAndPilotRecursion {

	private static int getMinimumSalary(int[] captains, int[] assistants, int currentIndx, int diff, int total) {
		int option1 = Integer.MAX_VALUE;
		int option2 = Integer.MAX_VALUE;
		//System.out.println(diff);
		if(currentIndx >= 2 * total)
			return  0;
		
		if (diff == 0) {
			option1 =  assistants[currentIndx] + getMinimumSalary(captains, assistants, currentIndx + 1, 1, total);
		}

		else if (diff == total) {
			option2 = captains[currentIndx] + getMinimumSalary(captains, assistants, currentIndx + 1, diff - 1, total);
		} else {
			option1 = assistants[currentIndx]
					+ getMinimumSalary(captains, assistants, currentIndx + 1, diff + 1, total);
			option2 = captains[currentIndx]
					+ getMinimumSalary(captains, assistants, currentIndx + 1, diff - 1, total);
		}
		return Integer.min(option1, option2);
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

		int minSalary = getMinimumSalary(captains, assistants, 0, 0, nDim / 2);

		System.out.println(minSalary);

		scanner.close();
	}

}
