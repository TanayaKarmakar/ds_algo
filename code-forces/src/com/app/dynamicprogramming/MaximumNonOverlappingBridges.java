package com.app.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Bridge implements Comparable<Bridge> {
	int northBankPos;
	int southBankPos;

	public Bridge(int northBankPos, int southBankPos) {
		this.northBankPos = northBankPos;
		this.southBankPos = southBankPos;
	}

	@Override
	public int compareTo(Bridge o) {
		if(this.northBankPos == o.northBankPos)
			return this.southBankPos - o.southBankPos;
		return this.northBankPos - o.northBankPos;
	}
}

public class MaximumNonOverlappingBridges {
	private static int maxSize(List<Bridge> bridges) {
		Collections.sort(bridges);
		int n = bridges.size();

		int[] lis = new int[n];
		lis[0] = 1;
		int maxLen = 1;

		for (int i = 1; i < bridges.size(); i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (bridges.get(j).southBankPos < bridges.get(i).southBankPos) {
					lis[i] = Integer.max(lis[j] + 1, lis[i]);
				}
			}
			maxLen = Integer.max(maxLen, lis[i]);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		List<Bridge> bridges = new ArrayList<>();
		bridges.add(new Bridge(8, 1));
		bridges.add(new Bridge(1, 2));
		bridges.add(new Bridge(4, 3));
		bridges.add(new Bridge(3, 4));
		bridges.add(new Bridge(5, 5));
		bridges.add(new Bridge(2, 6));
		bridges.add(new Bridge(6, 7));
		bridges.add(new Bridge(7, 8));

		int maxLen = maxSize(bridges);
		
		System.out.println(maxLen);
	}

}
