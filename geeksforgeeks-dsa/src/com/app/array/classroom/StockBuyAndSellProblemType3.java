package com.app.array.classroom;

import java.util.ArrayList;
import java.util.List;

class Interval {
	int buy, sell;
}

public class StockBuyAndSellProblemType3 {
	private static void stockBuySell(int[] arr) {
		int n = arr.length;
		int i = 0;
		List<Interval> intervals = new ArrayList<>();
		while (i < (n - 1)) {
			// local minima
			// an element is local minima if it is less than its next element at
			// the right side
			while ((i < (n - 1)) && arr[i] >= arr[i + 1])
				i++;

			Interval interval = new Interval();
			interval.buy = i;

			i = i + 1;
			// local maxima
			// an element is local maxima if it is greater than its next element
			// at the right side
			while ((i < n) && arr[i - 1] <= arr[i])
				i++;

			interval.sell = i - 1;

			intervals.add(interval);
		}

		for (i = 0; i < intervals.size(); i++) {
			System.out.println("Buy at day " + intervals.get(i).buy + " and sell at day " + intervals.get(i).sell);
		}
	}

	public static void main(String[] args) {
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };

		stockBuySell(price);
	}

}
