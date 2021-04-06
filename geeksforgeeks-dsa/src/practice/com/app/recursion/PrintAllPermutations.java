package practice.com.app.recursion;

import java.util.Scanner;

public class PrintAllPermutations {
    private static void swap(char[] strArr, int i, int j) {
        char tmp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = tmp;
    }

    private static void printAllPermutation(char[] strArr, int indx) {
        if(indx == strArr.length - 1) {
            String str = new String(strArr);
            System.out.println(str);
            return;
        }

        for(int j = indx; j < strArr.length; j++) {
            swap(strArr, indx, j);
            printAllPermutation(strArr, indx + 1);
            swap(strArr, j, indx);
        }
    }

    private static void printAllPermutation(String str) {
        char[] strArr = str.toCharArray();
        printAllPermutation(strArr, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        printAllPermutation(str);

        scanner.close();
    }
}
