package com.app.practice.array;

public class AddStringsLeetcode415 {
	private static String addStrings(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		
		StringBuilder sb = new StringBuilder();
		int i = m - 1;
		int j = n - 1;
		
		int carry = 0;
		
		while(i >= 0 && j >= 0) {
			int n1 = num1.charAt(i) - '0';
			int n2 = num2.charAt(j) - '0';
			int sum = (n1 + n2);
			if(carry > 0) {
				sum += carry;
			}
			
			if(sum > 9) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			sb.insert(0, String.valueOf(sum));
			i--;
			j--;
		}
		
		while(i >= 0) {
			int n1 = num1.charAt(i) - '0';
			if(carry > 0) {
				n1 += carry;
			}
			
			if(n1 > 9) {
				carry = n1 / 10;
				n1 = n1 % 10;
			} else {
				carry = 0;
			}
			sb.insert(0, String.valueOf(n1));
			i--;
		}
		
		while(j >= 0) {
			int n2 = num2.charAt(j) - '0';
			if(carry > 0) {
				n2 += carry;
			}
			
			if(n2 > 9) {
				carry = n2 / 10;
				n2 = n2 % 10;
			} else {
				carry = 0;
			}
			sb.insert(0, String.valueOf(n2));
			j--;
		}
		
		if(carry > 0)
			sb.insert(0, String.valueOf(carry));
		
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "9133";
		String s2 = "0";
		
		String ans = addStrings(s1, s2);
		
		System.out.println(ans);

	}

}
