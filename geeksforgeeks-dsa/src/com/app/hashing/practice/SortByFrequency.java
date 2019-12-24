package com.app.hashing.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortByFrequency {
	static class KeyValueComparator implements Comparator<Map.Entry<Integer, Integer>> {

		@Override
		public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			if (o1.getValue() == o2.getValue()) {
				return o1.getKey().compareTo(o2.getKey());
			} else if (o1.getValue() < o2.getValue()) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	private static void sortByFrequency(int[] arr) {
		int n = arr.length;
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				int tmp = map.get(arr[i]);
				map.put(arr[i], ++tmp);
			}
		}

		List<Map.Entry<Integer, Integer>> listOfEntries = new LinkedList<>(map.entrySet());

		Collections.sort(listOfEntries, new KeyValueComparator());

		int i = 0;
		for (Map.Entry<Integer, Integer> entry : listOfEntries) {
			int key = entry.getKey();
			int value = entry.getValue();
			while (value > 0) {
				arr[i] = key;
				value--;
				i++;
			}
		}
		
		System.out.println("After sorting the array is ");
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = { 5, 5, 4, 6, 4 };
		
		sortByFrequency(arr);
		
		arr = new int[] {9,9,9,2,5};
		
		sortByFrequency(arr);

	}

}
