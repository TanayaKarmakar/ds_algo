package com.app.practice;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
	private List<Integer> nums;
	private int prev;
	
	public ProductOfNumbers() {
		nums = new ArrayList<>();
		prev = 1;
	}
	
	public void add(int num) {
		if(num == 0) {
			nums = new ArrayList<>();
			nums.add(1);
			prev = 1;
		} else {
			prev *= num;
			nums.add(prev);
		}
	}
	
	public int getProduct(int k) {
		int n = nums.size();
		if(k >= n)
			return 0;
		return prev / nums.get(n - k - 1);
	}
}

public class ProductOfLastKNumbersLeetcode1352 {

	public static void main(String[] args) {
		ProductOfNumbers obj = new ProductOfNumbers();
		obj.add(3);
		obj.add(0);
		obj.add(2);
		obj.add(5);
		obj.add(4);

		System.out.println(obj.getProduct(2));
		
		System.out.println(obj.getProduct(3));
		
		System.out.println(obj.getProduct(4));
		
		obj.add(8);
		
		System.out.println(obj.getProduct(2));
	}

}
