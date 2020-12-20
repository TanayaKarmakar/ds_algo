package com.app.priorityqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAnAlmostSortedArray {
	private static List<Integer> sortKSortedArray(List<Integer> numbers, int k) {
		if (numbers.size() < k) {
			Collections.sort(numbers);
			return numbers;
		}
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		List<Integer> result = new ArrayList<>();
		Iterator<Integer> nItr = numbers.iterator();
		for (int i = 0; i < k; i++) {
			pQ.add(nItr.next());
		}

		while (nItr.hasNext()) {
			pQ.add(nItr.next());
			result.add(pQ.poll());
		}

		result.addAll(Stream
				.generate(pQ::remove)
				.limit(pQ.size())
				.collect(Collectors.toList()));

		return result;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, -1, 2, 6, 4, 5, 8);
		
		List<Integer> result = sortKSortedArray(list, 2);
		
		System.out.println(result);

	}

}
