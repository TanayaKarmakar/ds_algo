
public class Pattern {
	private static void printPattern(int n) {
		int cnt = n / 2;
		for (int i = 1; i <= n; i += 2) {
			StringBuilder sb = new StringBuilder();
			for (int k = 1; k <= cnt; k++) {
				sb.append(" ");
			}
			System.out.print(sb.toString());
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			cnt--;
			System.out.println();
		}
		cnt = 1;
		for (int i = n - 2; i >= 1; i-= 2) {
			StringBuilder sb = new StringBuilder();
			for (int k = 1; k <= cnt; k++) {
				sb.append(" ");
			}
			System.out.print(sb.toString());
			for (int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			cnt++;
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPattern(9);
	}

}
