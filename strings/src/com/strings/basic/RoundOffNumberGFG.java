package com.strings.basic;

public class RoundOffNumberGFG {
	private static int getRoundOff(int number) {
		int a = (number / 10) * 10; //smaller multiple
		int b = a + 10; //larger multiple
		
		return (number - a) > (b - number) ? b:a;
	}

	public static void main(String[] args) {
		int n = 4722;
		
		System.out.println("RoundOff - " + getRoundOff(n));
		n = 38;
		System.out.println("RoundOff - " + getRoundOff(n));
	}

}
