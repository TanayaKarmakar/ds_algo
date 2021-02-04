package com.app.practice.stack;

import java.util.Iterator;
import java.util.Stack;

public class RemoveAdjacentDuplicateLeetCode1047 {
    private static String removeDuplicates(String S) {
        if(S.length() == 1)
            return S;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
            if(stack.isEmpty() || stack.peek() != S.charAt(i))
                stack.push(S.charAt(i));
            else
                stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> sItr = stack.iterator();
        while(sItr.hasNext()) {
            sb.append(sItr.next());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(removeDuplicates(str));
    }
}
