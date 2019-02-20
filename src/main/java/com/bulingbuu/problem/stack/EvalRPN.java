package com.bulingbuu.problem.stack;

import java.util.Stack;

/**
 * @author bulingbuu
 * @date 19-2-20 下午4:55
 * <p>
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvalRPN {
    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[] strings = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(evalRPN.evalRPN(strings));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int i1 = Integer.parseInt(stack.pop());
                int i2 = Integer.parseInt(stack.pop());
                stack.push((i2 + i1) + "");

            } else if (s.equals("-")) {
                int i1 = Integer.parseInt(stack.pop());
                int i2 = Integer.parseInt(stack.pop());
                stack.push((i2 - i1) + "");
            } else if (s.equals("*")) {
                int i1 = Integer.parseInt(stack.pop());
                int i2 = Integer.parseInt(stack.pop());
                stack.push((i2 * i1) + "");
            } else if (s.equals("/")) {
                int i1 = Integer.parseInt(stack.pop());
                int i2 = Integer.parseInt(stack.pop());
                stack.push((i2 / i1) + "");
            } else {
                stack.push(s);
            }
        }


        return Integer.parseInt(stack.pop());
    }

}
