package com.gpr.apps;
import java.util.*;

public class ReverseSubstrings {
    public static void main(String[] args) {
    	System.out.println(reverseSubstrings("abd(jnb)asdf")); // abd(bnj)asdf
        System.out.println(reverseSubstrings("abdjnbasdf")); // abdjnbasdf
        System.out.println(reverseSubstrings("dd(df)a(ghhh)")); // dd(df)a(ghhh)
    }

    public static String reverseSubstrings(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            } else if (charArray[i] == ')') {
                int start = stack.pop() + 1;
                int end = i - 1;
                while (start < end) {
                    char temp = charArray[start];
                    charArray[start] = charArray[end];
                    charArray[end] = temp;
                    start++;
                    end--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (c != '(' && c != ')') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}


	

