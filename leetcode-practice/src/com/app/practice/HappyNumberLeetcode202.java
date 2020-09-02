package com.app.practice;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberLeetcode202 {
	private static boolean isHappy(int n) {
        Set<Integer> numSet = new HashSet<>();
        while(true) {
        	int temp = n;
        	int sum = 0;
        	while(temp != 0) {
        		sum += (temp % 10) * (temp % 10);
        		temp = temp / 10;
        	}
        	if(sum == 1)
        		return true;
        	if(numSet.contains(sum))
        		return false;
        	n = sum;
        	numSet.add(n);
        }
    }

	public static void main(String[] args) {
		int n = 19;
		
		System.out.println(isHappy(n));
		
		n = 45;
		
		System.out.println(isHappy(n));

	}

}
