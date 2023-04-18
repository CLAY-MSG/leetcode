package com.clay;

import java.util.Stack;

/**
 * 20. 有效的括号
 * @Author: MSG
 * @Date:
 * @Version 1.0
 */
public class ValidParentheses {
    public static void main(String[] args) {
      String s = "))";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> charsStack = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0){
            return false;
        }
        for (char ch : chars) {
            if (ch == '{' || ch == '(' || ch == '[') {
                charsStack.push(ch);
            } else {
                if (charsStack.empty()){
                    charsStack.push(ch);
                    continue;
                }
                Character peek = charsStack.peek();
                if (ch == '}' && peek == '{') {
                    charsStack.pop();
                } else if (ch == ']' && peek == '[') {
                    charsStack.pop();
                } else if (ch == ')' && peek == '(') {
                    charsStack.pop();
                } else {
                    charsStack.push(ch);
                }
            }
        }
        return charsStack.empty();
    }
}
