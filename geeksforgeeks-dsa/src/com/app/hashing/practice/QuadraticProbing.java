package com.app.hashing.practice;

import java.util.Arrays;

public class QuadraticProbing {
	private static void quadraticProbing(int[] arr, int hashSize) {
		int[] hashTable = new int[hashSize];

		int n = arr.length;
		Arrays.fill(hashTable, -1);
		//int counter = 0;

		for (int i = 0; i < n; i++) {
			int hashLoc = arr[i] % hashSize;
			if (hashTable[hashLoc] == -1) {
				hashTable[hashLoc] = arr[i];
			} else {
				for(int startLoc = 1; startLoc < hashSize; startLoc++) {
					int offSet = (hashLoc + (startLoc * startLoc))%hashSize;
					if(hashTable[offSet] == -1) {
						hashTable[offSet] = arr[i];
						break;
					}
				}
			}
		}
		
		displayHash(hashTable);
	}
	
	private static void displayHash(int[] hashTable) {
		for(int i = 0;i<hashTable.length;i++) {
			System.out.print(hashTable[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {21,10,32,43};
		int hashSize = 11;
		quadraticProbing(arr, hashSize);
	}

}
