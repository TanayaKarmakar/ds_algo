package com.app.practice.bitmagic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CombinationIterator {
	List<String> list;
	int len;

	public CombinationIterator(String characters, int combinationLength) {
		list = new ArrayList<>();
		len = combinationLength;
		populateList(characters);
		Collections.sort(list);
	}

	public String next() {
		return list.remove(0);
	}

	public boolean hasNext() {
		return list.size() > 0;
	}

	private void populateList(String str) {
		int n = str.length();
		int total = (int) Math.pow(2, n);
		for (int i = 0; i < total; i++) {
			int temp = i;
			int count = 0;
			while (temp != 0) {
				temp = temp & (temp - 1);
				count++;
			}

			if (count == len) {
				temp = i;
				int j = 0;
				StringBuilder sb = new StringBuilder();
				while (temp != 0) {
					if ((temp & 1) == 1) {
						sb.append(str.charAt(j));
					}
					j++;
					temp = temp >> 1;
				}
				list.add(sb.toString());
			}
		}
	}
}

public class IteratorForCombinationLeetcode1286 {

	public static void main(String[] args) {
		CombinationIterator iterator = new CombinationIterator("abc", 2);
		
		System.out.println(iterator.next()); // returns "ab"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "ac"
		System.out.println(iterator.hasNext()); // returns true
		System.out.println(iterator.next()); // returns "bc"
		System.out.println(iterator.hasNext()); // returns false

	}

}
