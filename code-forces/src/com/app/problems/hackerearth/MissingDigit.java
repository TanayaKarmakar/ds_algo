package com.app.problems.hackerearth;

public class MissingDigit {
	
	private static boolean isDigit(String str) {
		try {
			int num = Integer.parseInt(str);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	private static int performOperation(int n1, int n2, String op) {
		if(op.equals("+"))
			return (n1 + n2);
		else if(op.equals("-"))
			return (n1 - n2);
		else if(op.equals("*"))
			return (n1 * n2);
		else
			return (n1 / n2);
	}
	
	private static String missingDigit(String str) {
		String[] sArr = str.split("\\s+");
		String op = "";
		op = sArr[1];
		String num1 = sArr[0];
		String num2 = sArr[2];
		String result = sArr[4];
		if(!isDigit(result)) {
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			int res = performOperation(n1, n2, op);
			String actual = String.valueOf(res);
			for(int i = 0; i < actual.length(); i++) {
				if(actual.charAt(i) != result.charAt(i)) {
					return actual.charAt(i) + "";
				}
			}
		} else if(!isDigit(num1) || !isDigit(num2)) {
			int val = 0;
			String nonDigit = "";
			if(isDigit(num1)) {
				val =  Integer.parseInt(num1);
				nonDigit = num2;
			}
			if(isDigit(num2)) {
				val = Integer.parseInt(num2);
				nonDigit = num1;
			}
			
			int res = Integer.parseInt(result);
			if(op.equals("+")) {
				res -= val;
			} else if(op.equals("-")) {
				res += val;
			} else if(op.equals("*")) {
				res /= val;
			} else {
				res *= val;
			}
			String actual = String.valueOf(res);
			for(int i = 0; i < actual.length(); i++) {
				if(actual.charAt(i) != nonDigit.charAt(i))
					return actual.charAt(i) + "";
			}
		}
		return "";
	}

	public static void main(String[] args) {
		String str = "4 - 2 = x";
		
		System.out.println(missingDigit(str));
		
		str = "1x0 * 12 = 1200";
		
		System.out.println(missingDigit(str));
	}

}
