package practice.com.app.recursion;

import java.util.Scanner;

public class RopeCuttingProblem {
    private static int maxCuts(int n, int a, int b, int c) {
        if(n < 0)
            return -1;
        if(n == 0)
            return 0;
        int max = Integer.max(maxCuts(n - a, a, b, c),
                Integer.max(maxCuts(n - b, a, b, c), maxCuts(n - c, a, b, c)));
        if(max == -1)
            return -1;
        return 1 + max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int ans = maxCuts(n, a, b, c);

        System.out.println(ans);

        scanner.close();
    }
}
