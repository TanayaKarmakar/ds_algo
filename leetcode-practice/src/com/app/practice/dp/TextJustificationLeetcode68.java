package com.app.practice.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TextJustificationLeetcode68 {
	private static String formString(List<String> wordList, int maxWidth, boolean isLast) {
		int totalLen = 0;
		for (String word : wordList) {
			totalLen += word.length();
		}

		int remaining = maxWidth - totalLen;

		if (wordList.size() == 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(wordList.get(0));

			while (remaining > 0) {
				sb.append(" ");
				remaining--;
			}
			return sb.toString();
		}

		int n = wordList.size();
		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < n - 1; i++) {
			q.add(wordList.get(i));
		}

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

			StringBuilder sb = new StringBuilder();
			while (!q.isEmpty()) {
				sb.append(q.poll());
			}

			sb.append(wordList.get(n - 1));
			return sb.toString();
		} else {
			StringBuilder sb = new StringBuilder();

			while (!q.isEmpty() && remaining > 0) {
				sb.append(q.poll() + " ");
				remaining--;
			}
			sb.append(wordList.get(n - 1));

			while (remaining > 0) {
				sb.append(" ");
				remaining--;
			}

			return sb.toString();
		}
	}

	private static List<String> fullJustify(String[] words, int maxWidth) {
		List<List<String>> intermediate = new ArrayList<>();

		int n = words.length;

		int i = 0;
		while (i < n) {
			int currentWidth = maxWidth;
			List<String> currentLines = new ArrayList<>();
			while (i < n) {
				if (words[i].length() <= currentWidth) {
					currentLines.add(words[i]);
					currentWidth = currentWidth - words[i].length() - 1;
				} else {
					break;
				}
				i++;
			}
			intermediate.add(currentLines);
		}

		List<String> finalList = new ArrayList<>();
		int n1 = intermediate.size();

		for (i = 0; i < n1 - 1; i++) {
			finalList.add(formString(intermediate.get(i), maxWidth, false));
		}
		finalList.add(formString(intermediate.get(n1 - 1), maxWidth, true));
		return finalList;
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		int maxWidth = 16;

		List<String> finalList = fullJustify(words, maxWidth);

		System.out.println(finalList);

		words = new String[] { "What", "must", "be", "acknowledgment", "shall", "be" };
		maxWidth = 16;
		
		finalList = fullJustify(words, maxWidth);

		System.out.println(finalList);

	}

}
