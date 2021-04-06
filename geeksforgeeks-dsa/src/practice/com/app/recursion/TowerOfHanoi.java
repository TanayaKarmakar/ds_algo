package practice.com.app.recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    private static void toh(int n, String source, String aux, String dest) {
        if(n == 1) {
            System.out.println("Move disk " + n + " from " + source + " to " + dest);
            return;
        }
        toh(n - 1, source, dest, aux);
        System.out.println("Move disk " + n + " from " + source + " to " + dest);
        toh(n - 1, aux, source, dest);
    }

    public static void main(String[] args) {
        String source = "A";
        String aux = "B";
        String dest = "C";
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        toh(n, source, aux, dest);
    }
}
