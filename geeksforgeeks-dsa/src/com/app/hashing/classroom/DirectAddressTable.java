package com.app.hashing.classroom;

public class DirectAddressTable {
	private static void insert(boolean[] table, int num) {
		if(num >= 0 && num < table.length) {
			table[num] = true;
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
	}
	
	private static void delete(boolean[] table, int num) {
		if(num >= 0 && num < table.length) {
			table[num] = false;
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
	}
	
	private static boolean search(boolean[] table, int num) {
		if(num >= 0 && num < table.length) {
			return table[num];
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index");
		}
	}

	public static void main(String[] args) {
		int n = 1000;
		boolean[] table = new boolean[n];
		
		insert(table, 100);
		insert(table, 200);
		insert(table, 120);
		
		delete(table, 200);
		
		System.out.println("Found " + search(table, 100));
		System.out.println("Found " + search(table, 200));
	}

}
