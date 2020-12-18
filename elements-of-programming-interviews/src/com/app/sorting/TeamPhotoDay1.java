package com.app.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamPhotoDay1 {
	private static boolean canBePlaced(List<Integer> a, List<Integer> b) {
		int size = a.size();

		for (int i = 0; i < size; i++) {
			if (a.get(i) > b.get(i))
				return false;
		}
		return true;
	}

	private static void isArrangementPossible(List<Integer> teamA, List<Integer> teamB) {
		Collections.sort(teamA);
		Collections.sort(teamB);

		boolean resultAB = canBePlaced(teamA, teamB);
		if (resultAB) {
			System.out.println("Front Row : A, Back Row: B");
			return;
		}

		boolean resultBA = canBePlaced(teamB, teamA);
		if (resultBA) {
			System.out.println("Front Row: B, Back Row: A");
			return;
		}

		System.out.println("Arrangement is not possible");
	}

	public static void main(String[] args) {
		List<Integer> teamA = new ArrayList<>(List.of(15, 11, 9, 18, 10));
		List<Integer> teamB = new ArrayList<>(List.of(13, 6, 4, 5, 1));
		
		isArrangementPossible(teamA, teamB);

	}

}
