package com.app.questions.practice;

public class StringToInteger {
	private static int myAtoI(String str) {
		str = str.trim();
		if(str.isEmpty() || Character.isAlphabetic(str.charAt(0)))
			return 0;
		
		boolean isNeg = false;
		int start = 0;
		if(str.charAt(0) == '-' || str.charAt(0) == '+') {
			start++;
			if(str.charAt(0) == '-')
				isNeg = true;
		}
			
		int i = start;
		int n = str.length();
		long res = 0;
		while(i < n && Character.isDigit(str.charAt(i))) {
			char curr = str.charAt(i);
			if(res > Integer.MAX_VALUE)
				break;
			res = res * 10 + (curr - '0');
			i++;
		}
		
		if(isNeg) {
			if(res > Integer.MAX_VALUE)
				res = Integer.MIN_VALUE;
			else
				res = -res;
		} else {
			if(res > Integer.MAX_VALUE)
				res = Integer.MAX_VALUE;
		}
		return (int)res;
	}

	public static void main(String[] args) {
//		System.out.println(myAtoI("42"));
//		System.out.println(myAtoI("   -42"));
//		System.out.println(myAtoI("4193 with words"));
//		System.out.println(myAtoI("words and 987"));
//		System.out.println(myAtoI("-91283472332"));
		System.out.println(myAtoI("7375465635463453465"));
//		System.out.println(myAtoI("+1"));
//		System.out.println(myAtoI("-2147483647"));
	}

}
