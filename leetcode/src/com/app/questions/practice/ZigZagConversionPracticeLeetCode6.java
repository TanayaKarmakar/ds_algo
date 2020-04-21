package com.app.questions.practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//TBD
public class ZigZagConversionPracticeLeetCode6 {
	private static String convert(String s, int numRows) {
		int n = s.length();
		int count = 1;
		Map<Integer, List<Character>> map = new LinkedHashMap<>();
		boolean rev = false;
		List<Character> chars = new ArrayList<>();
		chars.add(s.charAt(0));
		map.put(0, chars);
		
		
		for(int i = 1; i < n;) {
			if(!rev) {
				while(i < n && count < numRows) {
					if(!map.containsKey(count)) {
						chars = new ArrayList<>();
						chars.add(s.charAt(i));
						map.put(count, chars);
					} else {
						map.get(count).add(s.charAt(i));
					}
					i++;
					count++;
				}
				rev = true;
				count = count - 2;
			} else {
				while(i < n && count >= 0) {
					if(!map.containsKey(count)) {
						chars = new ArrayList<>();
						chars.add(s.charAt(i));
						map.put(count, chars);
					} else {
						map.get(count).add(s.charAt(i));
					}
					i++;
					count--;
				}
				rev = false;
				count = count + 2;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, List<Character>> entry: map.entrySet()) {
			for(Character ch: entry.getValue()) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String str = "PAYPALISHIRING";
		
		int numRows = 3;

		String res = convert(str, numRows); 
		System.out.println(res);
		
		str = "tanaya";
		numRows = 10;
		
		res = convert(str, numRows); 
		System.out.println(res);
		
	}

}
