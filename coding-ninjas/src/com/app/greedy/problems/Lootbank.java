package com.app.greedy.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Jewellery implements Comparable<Jewellery> {
	int mass;
	int value;
	
	@Override
	public int compareTo(Jewellery o) {
		if(o.value != this.value)
			return o.value - this.value;
		return this.mass - o.mass;
	}
}

public class Lootbank {
	private static int findJustGreaterBag(Jewellery obj, List<Integer> bags) {
		int start = 0;
		int end = bags.size() - 1;
		int indx = -1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(mid + 1 < bags.size() && bags.get(mid) < obj.mass && bags.get(mid + 1) >= obj.mass)
				return mid + 1;
			else if(mid - 1 >= 0 && bags.get(mid - 1) < obj.mass && bags.get(mid) >= obj.mass)
				return mid;
			else if(bags.get(mid) > obj.mass) {
				indx = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}		
		}
		return indx;
	}
	
	private static long findMaxValue(List<Jewellery> jewelleries, List<Integer> bags, int n, int k) {
		Collections.sort(jewelleries);
		Collections.sort(bags);
		
		long ans = 0;
		
		for(Jewellery el: jewelleries) {
			int indx = findJustGreaterBag(el, bags);
			if(indx != -1) {
				bags.remove(indx);
				ans += el.value;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		List<Jewellery> jewelleries = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			Jewellery obj = new Jewellery();
			obj.mass = scanner.nextInt();
			obj.value = scanner.nextInt();
			jewelleries.add(obj);
		}
		
		List<Integer> bags = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			int wt = scanner.nextInt();
			bags.add(wt);
		}
		
		long ans = findMaxValue(jewelleries, bags, n, k);
		System.out.println(ans);
		scanner.close();

	}

}
