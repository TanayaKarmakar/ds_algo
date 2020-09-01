package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FizzBuzz {
	private static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if((i % 3) == 0 && (i % 5) == 0)
				list.add("FizzBuzz");
			else if((i % 3) == 0)
				list.add("Fizz");
			else if((i % 5) == 0)
				list.add("Buzz");
			else
				list.add(i + "");
		}
		
		return list;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		List<String> list = fizzBuzz(n);
		
		System.out.println(list);
		
		scanner.close();
	}

}
