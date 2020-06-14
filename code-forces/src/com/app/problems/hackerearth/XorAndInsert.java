package com.app.problems.hackerearth;

import java.util.Scanner;

class BinTrie {
	BinTrie left;
	BinTrie right;
}

public class XorAndInsert {
	
	private static void insert(BinTrie root, int num) {
		BinTrie curr = root;
		for(int i = 31; i >= 0; i--) {
			int b = (num >> i) & 1;
			if(b == 0) {
				if(curr.left == null) {
					curr.left = new BinTrie();
				}
				curr = curr.left;
			} else {
				if(curr.right == null) {
					curr.right = new BinTrie();
				}
				curr = curr.right;
			}
		}
	}
	
	private static int search(BinTrie root, int key) {
		BinTrie curr = root;
		String binStr = "";
		
		for(int i = 31; i >= 0; i--) {
			int b = (key >> i) & 1;
			if(curr == null)
				break;
			if(b == 0) {
				curr = curr.left;
				binStr += "0";
			} else {
				curr = curr.right;
				binStr += "1";
			}
		}
		return Integer.parseInt(binStr, 2);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		BinTrie root = new BinTrie();
		int start = 0;
		
		while(n-- > 0) {
			int queryType = scanner.nextInt();
			if(queryType == 1 || queryType == 2) {
				int num = scanner.nextInt();
				if(queryType == 1) {
					//insert(trie, num);
					insert(root, num ^ start);
				} else if(queryType == 2) {
					start = start ^ num;
				}
			} else if(queryType == 3) {
				//search
				int val = search(root, start);
				
				System.out.println(val);
			}
		}

		scanner.close();
	}

}
