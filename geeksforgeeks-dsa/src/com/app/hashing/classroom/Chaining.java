package com.app.hashing.classroom;

import java.util.LinkedList;

class MyHash {
	private final int BUCKET;
	private LinkedList<Integer>[] list;

	public MyHash(int bucket) {
		this.BUCKET = bucket;
		this.list = new LinkedList[BUCKET];
		for (int i = 0; i < BUCKET; i++) {
			this.list[i] = new LinkedList<Integer>();
		}
	}

	public void insert(int key) {
		int hash = hash(key);
		this.list[hash].add(key);
	}

	public void remove(int key) {
		int hash = hash(key);
		this.list[hash].remove(key);
	}

	public boolean search(int key) {
		int hash = hash(key);

		LinkedList<Integer> items = this.list[hash];

		for (Integer el : items) {
			if (el == key)
				return true;
		}
		return false;
	}

	public void printHash() {
		for (int i = 0; i < BUCKET; i++) {
			LinkedList<Integer> items = this.list[i];
			System.out.print("Item at bucket is - " + i + "  are ");
			if(!items.isEmpty()) {
				for (Integer el : items) {
					System.out.print(el + " --> ");
				}
			} else {
				System.out.print("Empty");
			}
			
			System.out.println();
		}
	}

	private int hash(int key) {
		return key % BUCKET;
	}
}

public class Chaining {

	public static void main(String[] args) {
		MyHash hash = new MyHash(7);
		hash.insert(50);
		hash.insert(21);
		hash.insert(58);
		hash.insert(17);
		hash.insert(15);
		hash.insert(49);
		hash.insert(56);
		hash.insert(22);
		hash.insert(23);
		hash.insert(25);

		hash.printHash();
	}

}
