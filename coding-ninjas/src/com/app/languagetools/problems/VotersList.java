package com.app.languagetools.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VotersList {
	private static List<Integer> getFinalList(int[] voters, int n) {
		List<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		Arrays.sort(voters);
		while(i < n && j < n) {
			j = i;
			while(j < n && voters[i] == voters[j]) {
				j++;
			}
			if(j - i >= 2) {
				res.add(voters[i]);
			}
			i = j;
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();

		int l1 = Integer.parseInt(inputStr.split("\\s+")[0]);
		int l2 = Integer.parseInt(inputStr.split("\\s+")[1]);
		int l3 = Integer.parseInt(inputStr.split("\\s+")[2]);
		int total = (l1 + l2 + l3);
		int[] voters = new int[total];
		int i = 0;
		while(i < total) {
			int item = scanner.nextInt();
			voters[i++] = item;
		}
		List<Integer> res = getFinalList(voters, total);
		System.out.println(res.size());
		for(Integer el: res) {
			System.out.println(el);
		}
		scanner.close();
	}

}
