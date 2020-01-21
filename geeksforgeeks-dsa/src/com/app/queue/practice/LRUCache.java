package com.app.queue.practice;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
	private Deque<Integer> dq;
	private Set<Integer> keySet;
	private int size;

	public LRUCache(int size) {
		dq = new LinkedList<>();
		keySet = new HashSet<>();
		this.size = size;
	}

	public void refer(int x) {
		if (!keySet.contains(x)) {
			if (dq.size() == size) {
				dq.removeLast();
			}
			dq.addFirst(x);
			keySet.add(x);
		} else {
			if (dq.getFirst() != x) {
				Iterator<Integer> qItr = dq.iterator();

				while (qItr.hasNext()) {
					if (qItr.next() == x) {
						qItr.remove();
						break;
					}
				}

				dq.addFirst(x);
			}
		}
	}

	public void display() {
		Iterator<Integer> qItr = dq.iterator();
		while (qItr.hasNext()) {
			System.out.print(qItr.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		
		cache.display();

	}

}
