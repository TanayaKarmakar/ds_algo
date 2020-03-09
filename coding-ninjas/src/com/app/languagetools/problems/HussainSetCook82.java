package com.app.languagetools.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class HussainSetCook82 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String dimensions = scanner.nextLine();
		int nDim = Integer.parseInt(dimensions.split("\\s+")[0]);
		int nQueries = Integer.parseInt(dimensions.split("\\s+")[1]);
		
		long[] nums = new long[nDim];
		String arrStr = scanner.nextLine();
		String[] els = arrStr.split("\\s+");
		
		for(int i = 0;i<nDim;i++) {
			nums[i] = Long.parseLong(els[i]);
		}
		
		Queue<Long> q = new LinkedList<>();
		int queryIndx = 0;
		int end = nDim - 1;
		List<Long> res = new ArrayList<>();
		Arrays.sort(nums);
		
		while(nQueries > 0) {
			long currentQuery = Long.parseLong(scanner.nextLine());
			long el = Long.MAX_VALUE;
			for(;queryIndx < currentQuery;queryIndx++) {
				if(end >= 0 && (q.isEmpty() || nums[end] > q.peek())) {
					el = nums[end];
					end--;
				} else {
					el = q.poll();
				}
				q.add(el/2);
			}
			System.out.println(el);
			res.add(el);
			nQueries--;
		}
		
//		for(Long el: res) {
//			System.out.println(el);
//		}
		scanner.close();

	}

}
