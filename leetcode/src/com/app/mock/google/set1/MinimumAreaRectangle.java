package com.app.mock.google.set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinimumAreaRectangle {
	private static int minAreaRect(int[][] point) {
		int n = point.length;
		Map<Integer, List<Integer>> rows = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			int x = point[i][0];
			int y = point[i][1];
			rows.computeIfAbsent(x, z -> new ArrayList<>()).add(y);
		}

		int ans = Integer.MAX_VALUE;

		Map<Integer, Integer> lastX = new HashMap<>();
		for (Map.Entry<Integer, List<Integer>> entry : rows.entrySet()) {
			if (entry.getValue().size() < 2)
				continue;
			int x = entry.getKey();
			List<Integer> yValues = entry.getValue();
			Collections.sort(yValues);
			for (int i = 0; i < yValues.size(); i++) {
				int y1 = yValues.get(i);
				for (int j = i + 1; j < yValues.size(); j++) {
					int y2 = yValues.get(j);
					int val = 40001 * y1 + y2;
					if (lastX.containsKey(val))
						ans = Integer.min(ans, (x - lastX.get(val)) * (y2 - y1));
					lastX.put(val, x);
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] point = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } };

		int minArea = minAreaRect(point);

		System.out.println(minArea);

		point = new int[][] { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 4, 1 }, { 4, 3 } };

		minArea = minAreaRect(point);
		
		System.out.println(minArea);
	}

}
