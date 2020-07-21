package com.app.gametheory.problems;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CalculateGrundyNumbers {
	private static int mex(int n1, int n2, int n3) {
		Set<Integer> set = new TreeSet<>();
		set.add(n1);
		set.add(n2);
		set.add(n3);
		
		int i = 0;
		for(Integer num: set) {
			if(num != i)
				return i;
			i++;
		}
		
		return set.size();
	}
	
	private static int grundy(int n) {
		if(n == 0 || n == 1)
			return n;
		return mex(grundy(n / 2), grundy(n / 3), grundy(n / 6));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		int ans = grundy(num);
		
		System.out.println(ans);
		
		scanner.close();

	}

}
