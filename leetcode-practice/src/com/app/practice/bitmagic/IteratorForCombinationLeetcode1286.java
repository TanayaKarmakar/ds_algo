package com.app.practice.bitmagic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CombinationIterator {
	List<String> list;
	
	public CombinationIterator(String characters, int combinationLength) {
		list = new ArrayList<>();
		generateCombination(characters, combinationLength);
		Collections.sort(list);
	}
	
	public String next() {
		return list.remove(0);
	}
	
	public boolean hasNext() {
		return list.size() > 0;
	}
	
	private void generateCombination(String str, int len) {
		int n = str.length();
		int nums = (int)Math.pow(2, n);
		
		for(int i = 0; i < nums; i++) {
			int k = i;
			int count = 0;
			while(k != 0) {
				count++;
				k = k & (k - 1);
			}
			
			if(count == len) {
				k = i;
				int j = 0;
				String newStr = "";
				while(k != 0) {
					if((k & 1) == 1) {
						newStr = newStr + str.charAt(j);
					}
					k = k >> 1;
					j++;
				}
				list.add(newStr);
			}
		}
	}
}

public class IteratorForCombinationLeetcode1286 {

	public static void main(String[] args) {
		CombinationIterator obj = new CombinationIterator("abc", 2);
		System.out.println(obj.next());
		System.out.println(obj.hasNext());

	}

}
