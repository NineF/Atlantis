package com.bulingbuu.problem.string;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring("pwwkew"));


    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int result = 1;
        int start = 0;
        int end = 1;
        boolean f = false;

        for (int i = 1; i < chars.length; i++) {
            f = false;
            for (int j = end - 1; j >= start; j--) {
                //相同的话，就将区间中的长度取出比较，并重置start为当前位置，end++；
                if (j >= chars.length) {
                    break;
                }
                if (chars[i] == chars[j]) {
                    result = Math.max(result, end - start);
                    start = j + 1;
                    end++;
                    f = true;
                    break;
                }
            }
            if (!f) {
                end++;
            }
        }

        result = Math.max(result, end - start);
        return result;
    }
}
