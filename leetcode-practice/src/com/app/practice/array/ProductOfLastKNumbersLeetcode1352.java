package com.app.practice.array;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
	List<Integer> list;
	int product;

	public ProductOfNumbers() {
		list = new ArrayList<>();
		product = 1;
		list.add(1);
	}

	public void add(int num) {
		if (num == 0) {
			list = new ArrayList<>();
			product = 1;
			list.add(1);
		} else {
			product = product * num;
			list.add(product);
		}
	}

	public int getProduct(int k) {
		int n = list.size();
		if (k < n)
			return product / list.get(n - k - 1);
		else
			return 0;
	}
}

public class ProductOflastKNumbersLeetcode1352 {

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
