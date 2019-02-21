package com.bulingbuu.problem.sort;

/**
 * @author bulingbuu
 * @date 19-2-21 上午9:45
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {
    public static void main(String[] args) {
        MySqrt sqrt = new MySqrt();
        System.out.println(sqrt.mySqrt(2147395599));
        System.out.println(Math.sqrt(2147395599));
    }


    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        double low = 1;
        double high = x;
        double mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            double tmp = mid * mid - x;
            if (Math.abs(tmp) < 0.0001) {
                return (int) (mid);
            }
            if (mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }

        }


        return 0;
    }
}
