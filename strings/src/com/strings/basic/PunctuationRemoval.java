package com.strings.basic;

public class PunctuationRemoval {

	public static void main(String[] args) {
		String str = "w{e}lco////me to Ge/eks$$$forGe@e?ks!!!!!!";
		
		str = str.replaceAll("\\p{Punct}", "");
		
		System.out.println(str);
	}

}
