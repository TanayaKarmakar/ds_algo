package com.app.augustchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class NumbersWithSameConsecutiveDifference {
	private static int[] numsSameConsecDiff(int N, int K) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= 9; i++) {
			q.add(i);
		}
		
		Set<Integer> set = new LinkedHashSet<>();
		while(!q.isEmpty()) {
			int num = q.poll();
			
			String numStr = String.valueOf(num);
			if(numStr.length() == N) {
				set.add(num);
				continue;
			}
			
			int lastDigit = num % 10;
			int n1 = lastDigit + K;
			int n2 = lastDigit - K;
			
			if(n1 >= 0 && n1 <= 9) {
				q.add((num * 10 + n1));
			}
			
			if(n2 >= 0 && n2 <= 9) {
				q.add((num * 10 + n2));
			}
		}
		List<Integer> list = new ArrayList<>(set);
		
		if(N == 1)
			list.add(0, 0);
		
		int[] res = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		int[] res = numsSameConsecDiff(N, K);
		
		System.out.println(Arrays.toString(res));
		
		scanner.close();

	}

}
