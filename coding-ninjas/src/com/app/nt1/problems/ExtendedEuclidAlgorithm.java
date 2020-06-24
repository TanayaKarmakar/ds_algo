package com.app.nt1.problems;

class Triplet {
	int x;
	int y;
	int gcd;
}

public class ExtendedEuclidAlgorithm {

	private static Triplet extendedEuclid(int a, int b) {
		if (b == 0) {
			Triplet ans = new Triplet();
			ans.gcd = a;
			ans.x = 1;
			ans.y = 0;
			return ans;
		}
		Triplet smallAns = extendedEuclid(b, a % b);
		Triplet newAns = new Triplet();
		newAns.gcd = smallAns.gcd;
		newAns.x = smallAns.y;
		newAns.y = smallAns.x - (a / b) * smallAns.y;
		return newAns;
	}

	public static void main(String[] args) {
		int a = 16;
		int b = 10;

		Triplet newAns = extendedEuclid(a, b);
		System.out.println("GCD - " + newAns.gcd);
		System.out.println("X - " + newAns.x);
		System.out.println("Y - " + newAns.y);

	}

}
