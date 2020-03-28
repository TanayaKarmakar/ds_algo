package com.app.dp1.problems;

public class MagicGridRecursion {
	private static int minHealth(int[][] hm, int si, int sj, int m, int n) {
		if (si == m - 1 || sj == n - 1)
			return 1;
		if (si >= m || sj >= n)
			return Integer.MAX_VALUE;
		int option1 = -1;
		int option2 = -1;
		//if (si + 1 < m) {
			option1 = minHealth(hm, si + 1, sj, m, n) - hm[si + 1][sj];
			//option1 = Integer.max(option1, 1);
		//}
		//if (sj + 1 < n) {
			option2 = minHealth(hm, si, sj + 1, m, n) - hm[si][sj + 1];
			//option2 = Integer.max(option2, 1);
		//}
		System.out.println("Option1 " + option1 + ": Option2 - " + option2);
		return Integer.min(option1, option2);

	}

	public static void main(String[] args) {
		int[][] hm = { { 0, 1, -3 }, { 1, -2, 0 } };

		int cost = minHealth(hm, 0, 0, 2, 3);
		
		System.out.println(cost);

	}

}
