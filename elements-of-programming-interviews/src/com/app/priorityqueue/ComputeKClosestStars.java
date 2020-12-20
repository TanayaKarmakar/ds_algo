package com.app.priorityqueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Star implements Comparable<Star> {
	int x, y, z;

	public Star(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double distance() {
		return Math.sqrt((x * x) + (y * y) + (z * z));
	}

	@Override
	public int compareTo(Star o) {
		return (int) (this.distance() - o.distance());
	}
}

public class ComputeKClosestStars {
	private static List<Star> findKClosestKStars(List<Star> stars, int k) {
		PriorityQueue<Star> pQ = new PriorityQueue<>(Collections.reverseOrder());

		Iterator<Star> sItr = stars.iterator();

		while (sItr.hasNext()) {
			pQ.add(sItr.next());

			if (pQ.size() == k + 1)
				pQ.remove();
		}

		return Stream.generate(pQ::remove)
				.limit(pQ.size()).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
