package com.app.nt1.problems;

class Triplet1 {
	int x;
	int y;
	int gcd;
}

public class MultiplicativeModuleInverse {
	private static Triplet1 extendedEuclid(int a, int b) {
		if (b == 0) {
			Triplet1 triplet = new Triplet1();
			triplet.gcd = a;
			triplet.x = 1;
			triplet.y = 0;
			return triplet;
		}
		Triplet1 smallAns = extendedEuclid(b, a % b);
		Triplet1 newAns = new Triplet1();
		newAns.gcd = smallAns.gcd;
		newAns.x = smallAns.y;
		newAns.y = (smallAns.x - (b / a) * smallAns.y);
		return newAns;
	}

	private static int mmInverse(int a, int b) {
		Triplet1 ans = extendedEuclid(a, b);
		return ans.x;
	}

	public static void main(String[] args) {
		int a = 12;
		int b = 5;

		int mmInverse = mmInverse(a, b);
		System.out.println(mmInverse);

	}

}
