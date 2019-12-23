package com.app.hashing.practice;

import java.util.Arrays;

public class LinearProbing {
	private static void linearProbing(int[] arr, int hashSize) {
		int n = arr.length;
		int[] hashTable = new int[hashSize];
		Arrays.fill(hashTable, -1);
		

		for (int i = 0; i < n; i++) {
			int hashLoc = arr[i] % hashSize;
			if (hashTable[hashLoc] == -1) {
				hashTable[hashLoc] = arr[i];
			} else {
				int startPoint = hashLoc;
				int offSet = (hashLoc + 1) % hashSize;
				while (hashTable[offSet] != -1 && offSet != startPoint) {
					offSet = (offSet + 1) % hashSize;
				}
				if(offSet != startPoint) {
					hashTable[offSet] = arr[i];
				}
			}
		}

		displayHashTable(hashTable);
	}

	private static void displayHashTable(int[] hashTable) {
		for (int i = 0; i < hashTable.length; i++) {
			System.out.print(hashTable[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 14, 24, 44 };
		int hashSize = 10;
		linearProbing(arr, hashSize);

		arr = new int[] { 9, 99, 999, 9999 };
		linearProbing(arr, hashSize);

	}

}
