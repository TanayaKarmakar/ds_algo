
public class Test {
	static void printAllKLength(String[] set, int k) {
		int n = set.length;
		printAllKLengthRec(set, "", 0, n, k);
	}

	// The main recursive method
	// to print all possible
	// strings of length k
	static void printAllKLengthRec(String[] set, String prefix, int start, int n, int k) {

		// Base case: k is 0,
		// print prefix
		if (k == 0) {
			System.out.println(prefix);
			return;
		}

		// One by one add all characters
		// from set and recursively
		// call for k equals to k-1
		for (int i = start; i < n; ++i) {

			// Next character of input added
			String newPrefix = prefix + "-" + set[i];

			// k is decreased, because
			// we have added a new character
			printAllKLengthRec(set, newPrefix, i + 1, n, k - 1);
		}
	}

	public static void main(String[] args) {
//		String[] strs = { "home", "cart", "maps", "home" };
//		printAllKLength(strs, 3);
		
		int el = 455955547;
		int el2 = 420098884;
		
		System.out.println(el);
		System.out.println(el2);

	}

}
