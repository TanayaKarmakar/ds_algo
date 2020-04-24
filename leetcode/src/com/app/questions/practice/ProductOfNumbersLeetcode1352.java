package com.app.questions.practice;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
	private List<Integer> numbers;
	private List<Integer> prefix;
	
	public ProductOfNumbers() {
		numbers = new ArrayList<>();
	}
	
	public void add(int num) {
		numbers.add(num);
		int val = 1;
		if(num == 0 || prefix == null) {
			prefix = new ArrayList<>();
		} else {
			if(!prefix.isEmpty()) {
				val = prefix.get(prefix.size() - 1);
			}	
		}
		if(num != 0) {
			prefix.add(val * num);
		}
	}
	
	public int getProduct(int k) {
		if(k > prefix.size())
			return 0;
		int n = prefix.size();
		int val = prefix.get(n - 1);
		int div = k == prefix.size() ? 1 : prefix.get(n - k - 1);
		return val / div;
		
	}
}

public class ProductOfNumbersLeetcode1352 {

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
