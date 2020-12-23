package com.app.search;

import java.util.List;

class MinMax {
	Integer min;
	Integer max;

	public MinMax(Integer min, Integer max) {
		this.min = min;
		this.max = max;
	}

	public static MinMax minMax(Integer a, Integer b) {
		return Integer.compare(a, b) < 0 ? new MinMax(a, b) : new MinMax(b, a);
	}
	
	public String toString() {
		return "Min - " + this.min + ": Max - " + this.max;
	}
}

public class FindTheMinAndMaxSimultaneously {
	public static MinMax findMinMax(List<Integer> list) {
		if (list.size() <= 1)
			return new MinMax(list.get(0), list.get(0));

		MinMax globalMinMax = new MinMax(list.get(0), list.get(1));

		for (int i = 2; i + 1 < list.size(); i += 2) {
			MinMax localMinMax = new MinMax(list.get(i), list.get(i + 1));
			globalMinMax = new MinMax(Integer.min(localMinMax.min, globalMinMax.min),
					Integer.max(localMinMax.max, globalMinMax.max));
		}

		return globalMinMax;
	}

	public static void main(String[] args) {
		List<Integer> list = List.of(2, 3, 9, 1, 3, 4, 15, 6, 7, 19);
		MinMax minMax = findMinMax(list);
		System.out.println(minMax);
		
	}

}
