package com.bulingbuu.search;

import java.text.DecimalFormat;

/**
 * @author bulingbuu
 * @date 18-11-7 下午7:22
 */
public class Sqrt {
    //这个只能精确到后5位
    private static double wc = 0.000001;

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.000000");
        for (int i = 1; i < 100; i++) {
            System.out.println(df.format(sqrt(i)));
        }

    }

    public static double sqrt(double x) {
        double min, max;
        if (x < 1) {
            min = x;
            max = 1;
        } else if (x == 1) {
            return x;
        } else {
            min = 1;
            max = x;
        }
        while (true) {
            double mid = min + (max - min) / 2;
            if ((mid + wc) * (mid + wc) > x && (mid - wc) * (mid - wc) < x) {
                return mid;
            } else if ((mid - wc) * (mid - wc) > x) {
                max = mid - wc;
            } else {
                min = mid + wc;
            }
        }

    }

}
