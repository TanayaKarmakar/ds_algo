package com.app.questions;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	private static boolean isHappy(int num) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		int tmp = num;
		
		while(true) {
			String numStr = String.valueOf(tmp);
			for(int i = 0; i < numStr.length(); i++) {
				int curr = numStr.charAt(i) - '0';
				sum = sum + (curr * curr);
			}
			if(sum == 1)
				return true;
			else {
				if(set.contains(sum))
					return false;
				else
					set.add(sum);
			}
			tmp = sum;
			sum = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(19));
		System.out.println(isHappy(116));
	}

}
