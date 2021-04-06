package practice.com.app.recursion;

import java.util.Scanner;

public class PalindromeWithRecursion {
    private static boolean isPal(String str, int start, int end) {
        if(start == end || start > end)
            return true;
        return str.charAt(start) == str.charAt(end) && isPal(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(isPal(str, 0, str.length() - 1));
    }
}
