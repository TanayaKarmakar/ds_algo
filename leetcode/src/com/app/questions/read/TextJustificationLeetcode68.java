package com.app.questions.read;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TextJustificationLeetcode68 {
	private static String formString(List<String> words, int maxWidth, boolean isLast) {
		int totalLength = 0;
		for(String word: words) {
			totalLength += word.length();
		}
		int remaining = maxWidth - totalLength;
		if(words.size() == 1) {
			StringBuilder sb = new StringBuilder();
			sb.append(words.get(0));
			while(remaining > 0) {
				sb.append(" ");
				remaining--;
			}
			return sb.toString();
		} 
		Queue<String> q = new LinkedList<>();
		for(int i = 0; i < words.size() - 1; i++) {
			q.add(words.get(i));
		}
		if(!isLast) {
			q.add(null);
			while(!q.isEmpty() && remaining > 0) {
				String item = q.poll();
				if(item == null) {
					q.add(null);
					continue;
				}
				q.add(item + " ");
				remaining--;
			}
			
			while(q.peek() != null) {
				q.add(q.poll());
			}
			
			q.poll();
			
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()) {
				sb.append(q.poll());
			}
			sb.append(words.get(words.size() - 1));
			return sb.toString();
		} else {
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty() && remaining > 0) {
				sb.append(q.poll() + " ");
				remaining--;
			}
			
			sb.append(words.get(words.size() - 1));
			while(remaining > 0) {
				sb.append(" ");
				remaining--;
			}
			return sb.toString();
		}
	}
	
	private static List<String> justify(String[] words, int maxWidth) {
		int n = words.length;
		int i = 0;
		List<List<String>> intermediate = new ArrayList<>();
 		while (i < n) {
			int currentWidth = maxWidth;
			List<String> lineWords = new ArrayList<>();
			while (currentWidth >= 0 && i < n) {
				if (words[i].length() <= currentWidth) {
					lineWords.add(words[i]);
					currentWidth = currentWidth - words[i].length() - 1;
					i++;
				} else {
					break;
				}
			}
			intermediate.add(lineWords);
		}
		
		System.out.println(intermediate);
		
		List<String> finalResult = new ArrayList<>();
		int size = intermediate.size();
		for(i = 0; i < size - 1; i++) {
			List<String> el = intermediate.get(i);
			String result = formString(el, maxWidth, false);
			finalResult.add(result);
		}
		String result = formString(intermediate.get(size - 1), maxWidth, true);
		finalResult.add(result);
		System.out.println(intermediate);
		return finalResult;
	}

	public static void main(String[] args) {
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		List<String> finalResult = justify(words, 16);
		System.out.println(finalResult);

		words = new String[] { "What", "must", "be", "acknowledgment", "shall", "be" };
		finalResult = justify(words, 16);
		System.out.println(finalResult);

		words = new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to",
				"a", "computer.", "Art", "is", "everything", "else", "we", "do" };

		finalResult = justify(words, 20);
		System.out.println(finalResult);
	}

}
