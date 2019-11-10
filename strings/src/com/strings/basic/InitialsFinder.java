package com.strings.basic;

public class InitialsFinder {
	private static final String SPACE = " ";

	private static String findInitials(String str) {
		if (str == null)
			return null;
		else if (str.length() == 1)
			return str.toUpperCase();
		else {
			String[] strArr = str.split("\\s+");
			StringBuilder sb = new StringBuilder();
			for (String curr : strArr) {
				sb.append(Character.toUpperCase(curr.charAt(0)));
				sb.append(SPACE);
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		String name = "Tanaya Karmakar";
		System.out.println("Initials of " + name + " is " + findInitials(name));
	}

}
