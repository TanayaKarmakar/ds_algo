
public class PatternCodingNinjas2 {
	private static void printPattern(int n) {
		StringBuilder sb = new StringBuilder();
		int start = 1;
		for (int i = 2 * n; i >= 1; i--) {
			if (i > n) {
				System.out.print(sb.toString());
				for (int j = start; j <= n; j++) {
					System.out.print(j);
				}
				sb.append(" ");
				System.out.println();
				start++;
			} 
			else if (i == n) {
				start--;
				sb.deleteCharAt(sb.length() - 1);
			} 
			else {
				start--;
				sb.deleteCharAt(sb.length() - 1);
				System.out.print(sb.toString());
				for (int j = start; j <= n; j++) {
					System.out.print(j);
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		printPattern(6);
	}

}
