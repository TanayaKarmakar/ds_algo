package com.app.fenwicktree.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class Event1 implements Comparable<Event1> {
	int pos;
	int l;
	int r;
	int val;
	
	@Override
	public int compareTo(Event1 o) {
		if(this.val == o.val)
			return o.l - this.l;
		else
			return o.val - this.val;
	}
	
	public String toString() {
		return "Val - " + val + ": L - " + l + ": R - " + r + ": Pos - " + pos;
	}
}

public class KQuery {
	private static int []bit;
	
	private static int query(int indx) {
		int sum = 0;
		for(;indx > 0; indx -=(indx & (-indx))) {
			sum += bit[indx];
		}
		return sum;
	}
	
	private static void update(int indx, int n) {
		for(;indx <= n; indx +=(indx & (-indx))) {
			bit[indx]++;
		}
	}
	
	private static int[] processQuery(Event1[] events, int n, int q, int len) {
		bit = new int[n + 1];
		int[] ans = new int[q + 1];
		
		for(int i = 1; i <= len; i++) {
			Event1 evt = events[i];
			if(evt.pos != 0) {
				//query
				int val = query(evt.r) - query(evt.l - 1);
				ans[evt.pos] = val;
			} else {
				//update
				update(evt.r, n);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		//int n = br.read() - '0';
		
		int[] arr = new int[n + 1];
//		String[] strArr = br.readLine().split("\\s+");
		for(int i = 1; i <= n; i++) {
			arr[i] = scanner.nextInt();
		}
		
		//int q = br.read() - '0';
		int q = scanner.nextInt();
		int[][] query = new int[q + 1][3];
		for(int i = 1; i <= q; i++) {
			int[] item = new int[3];
			//String[] queryArr = br.readLine().trim().split("\\s+");
			item[0] = scanner.nextInt(); //l
			item[1] = scanner.nextInt();  //r
			item[2] = scanner.nextInt(); //k
			query[i] = item;
		}
		
		Event1[] events = new Event1[n + q + 1];
		for(int i = 1; i <= n; i++) {
			Event1 evt = new Event1();
			evt.l = 0;
			evt.r = i;
			evt.pos = 0;
			evt.val = arr[i];
			events[i] = evt;
		}
		
		for(int i = n + 1; i <= (n + q); i++) {
			Event1 evt = new Event1();
			evt.l = query[i - n][0];
			evt.r = query[i - n][1];
			evt.val = query[i - n][2];
			evt.pos = i - n;
			events[i] = evt;
		}
		
		Arrays.sort(events, 1, n + q + 1);
		
		int[] ans = processQuery(events, n, q, n + q);
		
		for(int i = 1; i <= q; i++) {
			System.out.println(ans[i]);
		}
		scanner.close();
		//br.close();
	}
}
