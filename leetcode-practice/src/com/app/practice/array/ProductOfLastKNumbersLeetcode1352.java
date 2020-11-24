package com.app.practice.array;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
	private List<Integer> list;
	int prefix = 0;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        prefix = 1;
        list.add(prefix);
    }
    
    public void add(int num) {
        if(num == 0) {
        	list = new ArrayList<>();
        	prefix = 1;
        	list.add(prefix);
        } else {
        	prefix = prefix * num;
        	list.add(prefix);
        }
    }
    
    public int getProduct(int k) {
        if(k >= list.size())
        	return 0;
        int n = list.size();
        return list.get(n - 1) / list.get(n - k - 1);
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
