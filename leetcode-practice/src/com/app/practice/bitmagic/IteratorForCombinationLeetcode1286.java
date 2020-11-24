package com.app.practice.bitmagic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CombinationIterator {
	private List<String> list;

	public CombinationIterator(String characters, int combinationLength) {
		list = new ArrayList<>();
		buildIterator(characters, combinationLength);
	}

	public String next() {
		return list.remove(0);
	}

	public boolean hasNext() {
		return list.size() > 0;
	}

	private void buildIterator(String chars, int combinationLen) {
		int len = chars.length();
		int total = (int) Math.pow(2, len);

		for (int i = 0; i < total; i++) {
			int temp = i;
			int count = 0;
			while (temp != 0) {
				temp = temp & (temp - 1);
				count++;
			}

			if (count == combinationLen) {
				StringBuilder sb = new StringBuilder();

				temp = i;
				int j = 0;
				while (temp != 0) {
					if ((temp & 1) == 1) {
						sb.append(chars.charAt(j));
					}
					j++;
					temp = temp >> 1;
				}

				list.add(sb.toString());
			}
		}
		Collections.sort(list);
	}
}

public class IteratorForCombinationLeetcode1286 {

	public static void main(String[] args) {
		CombinationIterator cItr = new CombinationIterator("abc", 2);
		System.out.println(cItr.next());
		System.out.println(cItr.hasNext());
		System.out.println(cItr.next());
		System.out.println(cItr.hasNext());
		System.out.println(cItr.next());
		System.out.println(cItr.hasNext());

	}

}
