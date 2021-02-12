package com.app.practice.stack;

import java.util.Stack;

public class BackspaceStringCompareLeetCode844 {
    private static void populateStack(Stack<Character> stack, String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '#') {
                if(!stack.isEmpty())
                    stack.pop();
            } else
                stack.push(s.charAt(i));
        }
    }

    private static boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        populateStack(sStack, S);
        populateStack(tStack, T);

        while(!sStack.isEmpty() && !tStack.isEmpty()) {
            if(sStack.pop() != tStack.pop())
                return false;
        }

        if(!sStack.isEmpty() || !tStack.isEmpty())
            return false;

        return true;
    }

    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";

        System.out.println(backspaceCompare(S, T));
    }
}
