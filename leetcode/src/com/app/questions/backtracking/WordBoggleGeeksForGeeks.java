package com.app.questions.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}

public class WordBoggleGeeksForGeeks {
	private static boolean isSafe(int i, int j, int r, int c) {
		return (i >= 0 && i < r && j >= 0 && j < c);
	}
	
	private static boolean hasPath(String word, int indx, char[][] boggle, int i, int j, int r, int c, Set<Point> visited) {
		if(indx == word.length())
			return true;
		Point pt = new Point(i, j);
		visited.add(pt);
		int startR = i - 1;
		int endR = i + 1;
		int startC = j - 1;
		int endC = j + 1;
		
		for(int i1 = startR; i1 <= endR; i1++) {
			for(int j1 = startC; j1 <= endC; j1++) {
				if(isSafe(i1, j1, r, c) && !visited.contains(new Point(i1, j1))
						&& boggle[i1][j1] == word.charAt(indx)) {
					boolean hasPath = hasPath(word, indx + 1, boggle, i1, j1, r, c, visited);
					if(hasPath)
						return true;
					visited.remove(new Point(i1, j1));
				}
			}
		}
		return false;
	}
	
	private static List<String> getOutput(String[] words, char[][] boggle, int n, int r, int c) {
		Set<Point> visited = new HashSet<>();
		TreeSet<String> output = new TreeSet<>();
		
		for(String word: words) {
			int start = 0;
			visited.clear();
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(boggle[i][j] == word.charAt(start)) {
						boolean hasPath = hasPath(word, start + 1, boggle, i, j, r, c, visited);
						if(hasPath) {
							output.add(word);
						}
					}
				}
			}
		}
		
		return new ArrayList<>(output);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nTestCases = scanner.nextInt();
		
		while(nTestCases-- > 0) {
			int n = scanner.nextInt();
			String[] words = new String[n];
			for(int i = 0; i < n; i++) {
				words[i] = scanner.next();
			}
			
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			
			char[][] boggle = new char[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					boggle[i][j] = scanner.next().charAt(0);			
				}
			}
			
			List<String> output = getOutput(words, boggle, n, r, c);
			
			if (output.isEmpty()) {
				System.out.println("-1");
				continue;
			}
			
			for(String res: output) {
				System.out.print(res + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

}
