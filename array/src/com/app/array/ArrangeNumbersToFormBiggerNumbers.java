package com.app.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Given an array of numbers, arrange them in a 
//way that yields the largest value. For example, 
//if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 
//gives the largest value. And if the given numbers are
//{1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
public class ArrangeNumbersToFormBiggerNumbers {
	private static void reArrangeArray(List<String> numbers) {
		Collections.sort(numbers, (String item1, String item2) -> {
			String num1 = item1 + item2;
			String num2 = item2 + item1;
			return num1.compareTo(num2) > 0 ? -1 : 1;
		});

		numbers.forEach(item -> {
			System.out.print(item);
		});
	}

	public static void main(String[] args) {
		List<String> numbers = Arrays.asList("54","546","548","60");
		
		reArrangeArray(numbers);
	}

}
