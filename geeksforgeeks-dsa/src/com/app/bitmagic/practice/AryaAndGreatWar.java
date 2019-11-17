package com.app.bitmagic.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AryaAndGreatWar {
	private static int stabsNeeded(int n) {
		int count = 0;
		while(n > 0) {
			count++;
			n = n & (n - 1);
		}
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int nTestCase = scanner.nextInt();
		List<Integer> res = new ArrayList<>();
		
		while(nTestCase > 0) {
			int number = scanner.nextInt();
			res.add(stabsNeeded(number));
			nTestCase--;
		}
		
		for(Integer val: res) {
			System.out.println(val);
		}
		scanner.close();

	}

}
