package com.app.questions.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ElephantsAndTShirts {
	private static int totalWays(int[][] memo, int mask, int nPerson, Map<Integer, List<Integer>> map, int tid) {
		if (mask == ((1 << nPerson) - 1))
			return 1;
		if (tid == 101)
			return 0;
		if (memo[mask][tid] != -1)
			return memo[mask][tid];

		int ans = totalWays(memo, mask, nPerson, map, tid + 1);
		if (map.get(tid) != null) {
			for (Integer person : map.get(tid)) {
				if ((mask & (1 << person)) == 0) {
					ans += totalWays(memo, (mask | (1 << person)), person, map, tid + 1);
				}
			}
		}

		return ans;
	}

	private static int totalWays(int mask, int nPerson, Map<Integer, List<Integer>> map, int tid) {
		if (mask == ((1 << nPerson) - 1))
			return 1;
		if (tid == 101)
			return 0;
		int ans = totalWays(mask, nPerson, map, tid + 1);
		if (map.get(tid) != null) {
			for (Integer person : map.get(tid)) {
				if ((mask & (1 << person)) == 0) {
					ans += totalWays((mask | (1 << person)), nPerson, map, tid + 1);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = Integer.parseInt(scanner.nextLine().trim());
		while (nTestCases-- > 0) {
			int nPerson = Integer.parseInt(scanner.nextLine().trim());
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < nPerson; i++) {
				String inputStr = scanner.nextLine();
				// System.out.println(inputStr);
				String[] sArr = inputStr.split("\\s+");
				for (int j = 0; j < sArr.length; j++) {
					int key = Integer.parseInt(sArr[j]);
					if (!map.containsKey(key)) {
						List<Integer> persons = new ArrayList<>();
						persons.add(i);
						map.put(key, persons);
					} else {
						map.get(key).add(i);
					}
				}
			}
			int[][] memo = new int[1025][102];
			for (int i = 0; i <= 1024; i++) {
				Arrays.fill(memo[i], -1);
			}

			// int ans = totalWays(0, nPerson, map, 1);
			int ans = totalWays(memo, 0, nPerson, map, 1);
			System.out.println(ans);

			// System.out.println(map);

		}
		scanner.close();
	}

}
