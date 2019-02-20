package com.bulingbuu.problem.stack;

import java.util.Stack;

/**
 * @author bulingbuu
 * @date 19-2-20 下午3:46
 * <p>
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses validParentheses = new LongestValidParentheses();
        System.out.println(validParentheses.longestValidParentheses("()(())"));

    }

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int max = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i != s.length(); ++i){
            if (s.charAt(i) == '('){
                stack.push(i);
            }
            if (s.charAt(i) == ')'){
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = max > i - stack.peek()?max:i - stack.peek();
            }
        }

        return max;
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        Stack<Integer> stack = new Stack<>();
//        char[] chars = s.toCharArray();
//        boolean[] flag = new boolean[chars.length];
//
//        for (int i = 0; i < chars.length; i++) {
//            char c = chars[i];
//            if (isLeft(c)) {
//                stack.push(i);
//            } else {
//                if (stack.isEmpty()) {
//                    continue;
//                }
//                int xi=stack.pop();
//                if (c == ')') {
//                    flag[i] = true;
//                    flag[xi] = true;
//                }
//            }
//        }
//        int maxLen = 0;
//        int current = 0;
//        for (int i = 0; i < flag.length; i++) {
//            if (flag[i]) {
//                current++;
//            } else {
//                maxLen = Math.max(maxLen, current);
//                current = 0;
//            }
//        }
//        maxLen = Math.max(maxLen, current);
//
//        return maxLen;
    }

    private boolean isLeft(char c) {
        if (c == '(') {
            return true;
        }
        return false;
    }
}
