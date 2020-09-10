package com.app.interviewbit.array;

import java.util.ArrayList;

public class AddOneToTheNumber {
	private static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
		int size = A.size();
		int[] sum = new int[size + 1];
		
		int val = A.get(size - 1) + 1;
		int carry = 0;
		if(val > 0) {
			sum[size] = 0;
			carry = 1;
		} else {
			sum[size] = val;
		}
		
		for(int i = size; i > 0; i--) {
			val = A.get(i - 1) + carry;
			if(val > 9) {
				sum[i] = 0;
				carry = 1;
			} else {
				sum[i] = val;
				carry = 0;
			}
		}
		
		if(carry > 0)
			sum[0] = carry;
		
		int indx = 0;
		for(int i = 0; i <= size; i++) {
			if(sum[i] != 0) {
				break;
			} else {
				indx++;
			}
		}
		
		A = new ArrayList<>();
		for(int i = indx; i < sum.length; i++) {
			A.add(sum[i]);
		}
		
		return A;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		
		list = plusOne(list);
		
		System.out.println(list);
		
		list = new ArrayList<>();
		list.add(9);
		list.add(9);
		list.add(9);
		
		list = plusOne(list);
		
		System.out.println(list);

	}

}
