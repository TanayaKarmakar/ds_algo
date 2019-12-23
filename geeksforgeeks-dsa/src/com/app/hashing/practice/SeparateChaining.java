package com.app.hashing.practice;

import java.util.ArrayList;
import java.util.List;

public class SeparateChaining {
	private static void separateChaining(int[] arr, int hashSize) {
		List<List<Integer>> hashTable = new ArrayList<>(hashSize);
		for(int i = 0;i<hashSize;i++) {
			hashTable.add(new ArrayList<>());
		}
		
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int hash = arr[i] % hashSize;
			hashTable.get(hash).add(arr[i]);
		}
		displayHash(hashTable);
	}

	private static void displayHash(List<List<Integer>> hashTable) {
		for (int i = 0; i < hashTable.size(); i++) {
			List<Integer> bucket = hashTable.get(i);
			if (bucket != null && !bucket.isEmpty()) {
				System.out.print(i + "");
				for(Integer el: bucket) {
					System.out.print("->" + el);
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 92, 4, 14, 24, 44, 91 };
		int hashSize = 10;
		separateChaining(arr, hashSize);
	}

}
