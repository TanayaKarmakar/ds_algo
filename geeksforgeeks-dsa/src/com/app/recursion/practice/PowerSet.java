package com.app.recursion.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {
	private static void powerSet(String str, String curr, int indx, List<String> list) {
		if (indx == str.length()) {
			// System.out.print(curr + " ");
			list.add(curr);
			return;
		}
		powerSet(str, curr, indx + 1, list);
		powerSet(str, curr + str.charAt(indx), indx + 1, list);
	}

	private static List<String> powerSet(String str) {
		List<String> list = new ArrayList<>();
		powerSet(str, "", 0, list);
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		System.out.println(powerSet("abc"));
	}

}
