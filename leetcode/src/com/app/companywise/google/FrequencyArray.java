package com.app.companywise.google;

import java.util.HashMap;
import java.util.Map;

public class FrequencyArray {
	private static int getLargeButMin(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				int tmp = map.get(arr[i]);
				map.put(arr[i], ++tmp);
			}
		}
		
		int minFreq = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int num = entry.getKey();
			int freq = entry.getValue();
			if(freq < minFreq) {
				minFreq = freq;
				maxValue = num;
			} else if(freq == minFreq && maxValue < num) {
				maxValue = num;
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		System.out.println(getLargeButMin(new int[] {2, 2, 5, 50, 1}, 5));

	}

}
