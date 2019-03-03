package com.bulingbuu.problem.string;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class ZConvert {

    public static void main(String[] args) {
        ZConvert convert = new ZConvert();
        String result = convert.convert("AB", 2);
        System.out.println(result);
    }

    public String convert(String s, int numRows) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        if (numRows==1){
            return s;
        }
        int t = numRows * 2 - 2;

        StringBuilder sb = new StringBuilder();

        int i = 0;
        //第一行
        for (int j = i; j < length; j += t) {
            sb.append(s.charAt(j));
        }
        i++;
        while (i < numRows - 1) {
            int k = numRows -i-1;
            for (int j = i; j < length; j += t) {
                sb.append(s.charAt(j));
                int m = j + k * 2;
                if (m < length) {
                    sb.append(s.charAt(m));
                }
            }
            i++;

        }

        //最后一行
        for (int j = i; j < length; j += t) {
            sb.append(s.charAt(j));
        }

        return sb.toString();
    }
}
