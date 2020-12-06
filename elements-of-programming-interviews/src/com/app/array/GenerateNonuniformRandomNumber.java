package com.app.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GenerateNonuniformRandomNumber {
	private static int getNumber(List<Integer> values, List<Double> probabilities) {
		List<Double> prefixSumProbabilities = new ArrayList<>();
		double preSum = 0;
		for (double prob : probabilities) {
			preSum += prob;
			prefixSumProbabilities.add(preSum);
		}

		Random rand = new Random();
		double uniform = rand.nextDouble();
		int indx = Collections.binarySearch(prefixSumProbabilities, uniform);
		if (indx < 0) {
			int actualIndx = (int) Math.abs(indx) - 1;
			return values.get(actualIndx);
		} else {
			return values.get(indx);
		}

	}

	public static void main(String[] args) {
		List<Integer> values = new ArrayList<>();
		values.add(3);
		values.add(5);
		values.add(7);
		values.add(11);

		List<Double> probabilities = new ArrayList<>();
		probabilities.add(9 / 18.0);
		probabilities.add(6 / 18.0);
		probabilities.add(2 / 18.0);
		probabilities.add(1 / 18.0);

		
		int ans = getNumber(values, probabilities);
		
		System.out.println(ans);
	}

}
