package com.app.greedy.practice;

import java.util.Arrays;
import java.util.Comparator;

class Item {
	int value;
	int weight;

	public Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}

class ItemComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		float ratio1 = o1.value / (float) o1.weight;
		float ratio2 = o2.value / (float) o2.weight;
		if (ratio1 < ratio2)
			return 1;
		else if (ratio1 > ratio2)
			return -1;
		else
			return 0;
	}

}

public class FractionalKnapsack {
	private static double fractionalKnapsack(Item[] arr, int w, int n) {
		Arrays.sort(arr, new ItemComparator());
		double totalProfit = 0;
		int wt = 0;
		for (Item item : arr) {
			if (wt + item.weight <= w) {
				wt += item.weight;
				totalProfit += item.value;
			} else {
				int diff = (w - wt);

				totalProfit += (diff / (float) item.weight) * item.value;
				wt += diff;
			}
		}

		return totalProfit;
	}

	public static void main(String[] args) {
		Item[] arr = new Item[3];
		arr[0] = new Item(60, 10);
		arr[1] = new Item(100, 20);
		arr[2] = new Item(120, 30);

		System.out.println("Total profit - " + fractionalKnapsack(arr, 50, arr.length));

		arr = new Item[2];
		arr[0] = new Item(60, 10);
		arr[1] = new Item(100, 20);

		System.out.println("Total profit - " + fractionalKnapsack(arr, 50, arr.length));

	}

}
