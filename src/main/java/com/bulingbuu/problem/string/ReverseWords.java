package com.bulingbuu.problem.string;

/**
 * @author bulingbuu
 * @date 19-2-21 上午10:39
 * <p>
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例:
 * <p>
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * 说明:
 * <p>
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * <p>
 * 进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。
 */
public class ReverseWords {
    public static void main(String[] args) {

        String s = " asfs   sfs sdf  ee  ";
        ReverseWords words = new ReverseWords();
        System.out.println(words.reverseWords(s));
    }

    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) {
                continue;
            }
            sb.append(str[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
