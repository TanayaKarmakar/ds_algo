package com.app.languagetools.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PalindromicPermutation {
	private static void palindromicPermutation(String str, List<int[]> res) {
		Map<Character, List<Integer>> indexMap = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!indexMap.containsKey(str.charAt(i))) {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				indexMap.put(str.charAt(i), indices);
			} else {
				indexMap.get(str.charAt(i)).add(i);
			}
		}
		
		int oddCount = 0;
		for(Map.Entry<Character, List<Integer>> entry: indexMap.entrySet()) {
			if(entry.getValue().size() % 2 != 0)
				oddCount++;
		}
		
		if(oddCount >= 2) {
			res.add(new int[] {-1});
			return;
		}

		int[] itemsArr = new int[str.length()];
		int start = 0;
		int end = itemsArr.length - 1;
		for (Map.Entry<Character, List<Integer>> entry : indexMap.entrySet()) {
			char ch = entry.getKey();
			List<Integer> values = entry.getValue();
			for (int j = 0; j < values.size(); j+=2) {
				if(values.size() - j == 1) {
					itemsArr[str.length()/2] = j;
					continue;
				}
				itemsArr[start] = values.get(j);
				itemsArr[end] = values.get(j + 1);
				start++;
				end--;
			}
		}
		res.add(itemsArr);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nDim = Integer.parseInt(scanner.nextLine());

		int i = 0;
		List<int[]> res = new ArrayList<>();
		while (i < nDim) {
			String str = scanner.nextLine();
			palindromicPermutation(str, res);
			i++;
		}
		
		for(int[] items: res) {
			for(int el: items) {
				if(el != -1) {
					el = el + 1;
				}
				System.out.print(el + " ");
			}
			System.out.println();
		}

		scanner.close();
	}
}
