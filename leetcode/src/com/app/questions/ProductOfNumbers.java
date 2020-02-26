package com.app.questions;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
	private List<Integer> nums;
	int prev;

	public ProductOfNumbers() {
		prev = 1;
		this.nums = new ArrayList<>();
		this.nums.add(1);
	}

	public void add(int num) {
		//nums.add(num);
		if(num > 0) {
			prev *= num;
			this.nums.add(prev);
		} else {
			prev = 1;
			this.nums = new ArrayList<>();
			this.nums.add(1);
		}
	}

	public int getProduct(int k) {
		int n = nums.size();
		
		if(k < n)
			return prev / nums.get(n - k - 1);
		else
			return 0;
	}

	public static void main(String[] args) {
		ProductOfNumbers pon = new ProductOfNumbers();
		pon.add(3);
		pon.add(0);
		pon.add(2);
		pon.add(5);
		pon.add(4);
		System.out.println(pon.getProduct(2));
		System.out.println(pon.getProduct(3));
		System.out.println(pon.getProduct(4));
		pon.add(8);
		System.out.println(pon.getProduct(2));
	}

}
