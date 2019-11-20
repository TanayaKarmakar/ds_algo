
// *****
//  ****
//   ***
//    **
//     *
//    **
//   ***
//	****
// *****
public class PatternCodingNinjas1 {
	private static void printPattern(int n) {
		StringBuilder sb = new StringBuilder();
		int tmp = n;
		for (int i = 2 * n; i >= 1; i--) {
			if (i > n) {
				System.out.print(sb.toString());
				for (int j = 1; j <= tmp; j++) {
					System.out.print("*");
				}
				sb.append(" ");
				System.out.println();
				tmp--;
			} else if (i == n) {
				tmp = tmp + 1;
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.deleteCharAt(sb.length() - 1);
				System.out.print(sb.toString());
				tmp = tmp + 1;
				for (int j = 1; j <= tmp; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		printPattern(5);
	}

}
