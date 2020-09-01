package com.app.augustchallenge;

import java.util.Random;
import java.util.Scanner;

public class ImplementRand10UsingRang7 {
	private static Random rand = new Random();
	
	private static int rand7() {
		return rand.nextInt(7);
	}
	
	private static int rand10() {
		int indx = 41;
		while(indx > 40) {
			indx = (rand7() - 1) * 7 + rand7();
		}
		return ((indx - 1) % 10) + 1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		while(n > 0) {
			int ans = rand10();
			
			System.out.println(ans);
			n--;
		}
		scanner.close();
	}
}
