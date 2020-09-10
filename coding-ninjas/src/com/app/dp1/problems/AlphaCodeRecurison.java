package com.app.dp1.problems;

//need to fix
public class AlphaCodeRecurison {
	private static int numWays(int[] code, int size) {
		if (size == 0 || size == 1)
			return 1;
		int output = numWays(code, size - 1);
		if (code[size - 2] * 10 + code[size - 1] <= 26)
			output += numWays(code, size - 2);

		return output;
	}

	public static void main(String[] args) {
		int[] code = { 2, 3, 1, 4 };
		int totalWays = numWays(code, code.length);
		
		System.out.println("TotalWays - " + totalWays);

	}

}
