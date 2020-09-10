import java.util.Scanner;

public class TestClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int  nTestCases = Integer.parseInt(scanner.nextLine());
		while(nTestCases > 0) {
			int nDim = scanner.nextInt();
			int[] items = new int[nDim];
			for(int i = 0;i<nDim;i++) {
			     items[i] = scanner.nextInt();
			}


			System.out.println(“Displaying the array”);
			for(int i = 0;i<nDim;i++) {
				System.out.print(items[i] + “  “);
			}
			System.out.println();
			nTestCases--;
		}
		scanner.close();
	}
}
