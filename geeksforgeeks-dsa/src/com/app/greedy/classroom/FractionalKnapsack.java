package com.app.greedy.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Item implements Comparable<Item> {
	int weight;
	int profit;
	int cost;

	public Item(int weight, int profit, int cost) {
		this.weight = weight;
		this.profit = profit;
		this.cost = cost;
	}

	@Override
	public int compareTo(Item o) {
		if (this.cost == o.cost)
			return 0;
		else if (this.cost < o.cost)
			return 1;
		else
			return -1;
	}

}

public class FractionalKnapsack {
	private static void findMaxProfit(int[] weight, int[] profit, int totalWeight) {
		int n = weight.length;
		List<Item> items = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			items.add(new Item(weight[i], profit[i], profit[i] / weight[i]));
		}

		Collections.sort(items);

		int res = 0;
		int totWt = 0;
		for (Item item : items) {
			if (item.weight + totWt <= totalWeight) {
				totWt += item.weight;
				res += item.profit;
			} else {
				int wt = totalWeight - totWt;
				if (totalWeight > 0) {
					double value = item.profit * (wt / (double)item.weight);
					res += value;
					totWt += wt;
				}
				break;
			}
		}

		System.out.println("TotalWeight - " + totWt);
		System.out.println("TotalProfit - " + res);

	}

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };
		int capacity = 50;
		findMaxProfit(wt, val, capacity);
	}

}
