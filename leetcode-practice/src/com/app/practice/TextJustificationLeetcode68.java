package com.app.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class TextJustificationLeetcode68 {
	private static String formString(List<String> wordList, int maxWidth, boolean isLast) {
		int totalLength = 0;
		for (String word : wordList) {
			totalLength += word.length();
		}

		int remaining = maxWidth - totalLength;
		int n = wordList.size();

		if (wordList.size() == 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(wordList.get(0));

			while (remaining > 0) {
				sb.append(" ");
				remaining--;
			}
			return sb.toString();
		}

		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < n - 1; i++) {
			q.add(wordList.get(i));
		}

		StringBuilder sb = new StringBuilder();
		if (!isLast) {
			q.add(null);
			while (remaining > 0) {
				String item = q.poll();
				if (item == null) {
					q.add(null);
					continue;
				}
				q.add(item + " ");
				remaining--;
			}

			while (q.peek() != null) {
				q.add(q.poll());
			}
			q.poll();

			while (!q.isEmpty()) {
				sb.append(q.poll());
			}

			sb.append(wordList.get(n - 1));

		} else {
			while (!q.isEmpty() && remaining > 0) {
				sb.append(q.poll() + " ");
				remaining--;
			}
			
			sb.append(wordList.get(n - 1));

			while (remaining > 0) {
				sb.append(" ");
				remaining--;
			}
		}
		return sb.toString();
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<List<String>> intermediate = new ArrayList<>();
		int n = words.length;

		int i = 0;
		while (i < n) {
			int currentWidth = maxWidth;
			List<String> wordList = new ArrayList<>();
			while (i < n && currentWidth > 0) {
				if (words[i].length() <= currentWidth) {
					wordList.add(words[i]);
					currentWidth = currentWidth - words[i].length() - 1;
					i++;
				} else {
					break;
				}
			}
			intermediate.add(wordList);
		}

		List<String> finalList = new ArrayList<>();
		int m = intermediate.size();
		for (i = 0; i < m - 1; i++) {
			List<String> wordList = intermediate.get(i);
			finalList.add(formString(wordList, maxWidth, false));
		}
		finalList.add(formString(intermediate.get(m - 1), maxWidth, true));
		return finalList;
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		List<String> finalList = fullJustify(words, 16);

		System.out.println(finalList);

		words = new String[] { "What", "must", "be", "acknowledgment", "shall", "be" };

		finalList = fullJustify(words, 16);

		System.out.println(finalList);

		words = new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to",
				"a", "computer.", "Art", "is", "everything", "else", "we", "do" };
		
		finalList = fullJustify(words, 20);

		System.out.println(finalList);
	}

}
