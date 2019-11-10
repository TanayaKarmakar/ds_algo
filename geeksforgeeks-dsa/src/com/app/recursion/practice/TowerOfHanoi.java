package com.app.recursion.practice;

public class TowerOfHanoi {
	private static void moveTower(int nDisk, String source, String destination, String auxiliary) {
		if(nDisk >= 1) {
			moveTower(nDisk - 1, source, auxiliary, destination);
			System.out.println("Move disk " +nDisk + " from " + source + " to " + destination);
			moveTower(nDisk - 1, auxiliary, destination, source);
		}
	}

	public static void main(String[] args) {
		moveTower(3, "source", "dest", "aux");

   }

}
