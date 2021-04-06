package practice.com.app.mathematics.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ComputingRoots {
    private static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> list = new ArrayList<>();
        double commonPart = Math.pow(b, 2) - (4 * a * c);
        if(commonPart < 0) {
            list.add(-1);
            return list;
        }
        commonPart = Math.sqrt(commonPart);
        double x1 = (-b + commonPart) / (2.0 * a);
        double x2 = (-b - commonPart) / (2.0 * a);
        list.add((int)x1);
        list.add((int)x2);
        return list;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        List<Integer> results = quadraticRoots(a, b, c);
        System.out.println(results);

        scanner.close();
    }
}
