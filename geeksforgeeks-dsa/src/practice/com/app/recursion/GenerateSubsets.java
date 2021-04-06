package practice.com.app.recursion;

import java.util.Scanner;

public class GenerateSubsets {
    private static void generateSubsets(String curr, String str, int indx) {
        if(indx == str.length()) {
            System.out.println(curr);
            return;
        }
        generateSubsets(curr, str, indx + 1);
        generateSubsets(curr + str.charAt(indx), str, indx + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();

        generateSubsets("", txt, 0);
        scanner.close();
    }
}
