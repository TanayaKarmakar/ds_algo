package com.app.practice.math;

import java.util.ArrayList;
import java.util.List;

public class DivideTwoIntegersLeetcode29 {
	private static final int HALF_MIN = Integer.MIN_VALUE / 2;
	
	private static int divide(int dividend, int divisor) {
		if(dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		int negatives = 2;
		if(dividend > 0) {
			negatives--;
			dividend = -dividend;
		}
		
		if(divisor > 0) {
			negatives--;
			divisor = -divisor;
		}
		
		List<Integer> powers = new ArrayList<>();
		List<Integer> doubles = new ArrayList<>();
		
		int powerOfTwo = -1;
		
		while(divisor >= dividend) {
			doubles.add(divisor);
			powers.add(powerOfTwo);
			
			if(divisor < HALF_MIN)
				break;
			
			divisor += divisor;
			powerOfTwo += powerOfTwo;
		}
		
		int quotient = 0;
		
		for(int i = doubles.size() - 1; i >= 0; i--) {
			if(doubles.get(i) >= dividend) {
				quotient += powers.get(i);
				dividend -= doubles.get(i);
			}
		}
		
		if(negatives != 1)
			quotient = -quotient;
		
		return quotient;
	}

	public static void main(String[] args) {
		int dividend = 10;
		int divisor = 3;
		
		int ans = divide(dividend, divisor);
		
		System.out.println(ans);

	}

}
