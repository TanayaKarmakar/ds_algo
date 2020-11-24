package com.app.questions.strings;

public class ValidNumberLeetcode65 {
	private static boolean isNumber(String s) {
		char[] arr = s.trim().toCharArray();
		
		int n = arr.length;
		
		boolean valid = false;
		boolean dotFound = false;
		boolean firstDotFound = false;
		
		for(int i = 0; i < n; i++) {
			if(arr[i] >= '0' && arr[i] <= '9') {
				valid = true;
			} else if((arr[i] == '+' || arr[i] == '-') && i == 0)
				continue;
			else if(arr[i] == 'e') {
				if(i == 0 || i == n - 1) {
					valid = false;
					break;
				} else if(!hasValidChars(s.trim(), i + 1)) {
					valid = false;
					break;
				} else if(arr[i - 1] < '0' || arr[i - 1] > '9') {
					if(arr[i - 1] == '.' && !firstDotFound) {
						break;
					}
					valid = false;
					break;
				} else {
					break;
				}
			} else if(arr[i] == '.') {
				if(dotFound) {
					valid = false;
					break;
				}
				
				dotFound = true;
				
				if(i == 0) {
					firstDotFound = true;
				}
				continue;
			} else {
				valid = false;
				break;
			}
		}
		
		return valid;
	}
	
	private static boolean hasValidChars(String s, int start) {
		char[] arr = s.toCharArray();
		boolean valid = true;
		for(int i = start; i < arr.length; i++) {
			if(i == start && start < arr.length - 1 && (arr[i] == '+' || arr[i] == '-')) {
				continue;
			} else if(arr[i] < '0' || arr[i] > '9') {
				valid = false;
				break;
			}
		}
		
		return valid;
	}

	public static void main(String[] args) {
		String s = ".1.";
		
		System.out.println(isNumber(s));

	}

}
