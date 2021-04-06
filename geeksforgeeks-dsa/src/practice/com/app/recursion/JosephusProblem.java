package practice.com.app.recursion;

import java.util.Scanner;

public class JosephusProblem {
    private static int getIndex(int n, int k) {
        if(n == 1)
            return 0;
        return (getIndex(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = getIndex(n, k);
        System.out.println(ans);

        scanner.close();
    }
}
