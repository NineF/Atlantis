package com.bulingbuu.problem.stack;

import java.util.Stack;

/**
 * @author bulingbuu
 * @date 19-2-20 下午3:22
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {
    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("}"));
        System.out.println((int) '{');
        System.out.println((int) '}');
        System.out.println((int) '[');
        System.out.println((int) ']');
        System.out.println((int) '(');
        System.out.println((int) ')');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<String> strings = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (isLeft(chars[i])) {
                strings.push(chars[i] + "");
            } else {
                if (strings.isEmpty()){
                    return false;
                }
                String sc = strings.pop();
                char cc = sc.charAt(0);
                int cz = chars[i] - cc;
                if (cz != 2 && cz != 1) {
                    return false;
                }
            }
        }
        if (strings.isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean isLeft(char c) {
        if (c == '{' || c == '(' || c == '[') {
            return true;
        }
        return false;
    }
}
