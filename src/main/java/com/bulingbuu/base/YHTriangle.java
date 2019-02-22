package com.bulingbuu.base;

/**
 * @author bulingbuu
 * @date 19-1-27 下午8:18
 */
public class YHTriangle {

    int[][] matrix = { { 5 }, { 7, 8 }, { 2, 3, 4 }, { 4, 9, 6, 1 }, { 2, 7, 9, 4, 5 } };

    public int triangle(int[][] matrix) {
        int length = matrix.length;
        int[][] item = new int[length][length];
        item[0][0] = matrix[0][0];
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                //右边
                int tmp = Integer.MAX_VALUE;
                //避免边界问题
                if (j != matrix[i].length - 1) {
                    tmp = item[i - 1][j] + matrix[i][j];
                }
                //左边
                if (j != 0) {
                    int tmp1 = item[i - 1][j - 1] + matrix[i][j];
                    if (tmp1 < tmp) {
                        tmp = tmp1;
                    }
                }
                item[i][j] = tmp;
            }
        }

        int result=item[length - 1][0];
        for (int i = 0; i < length; i++) {
            result=Math.min(result,item[length-1][i]);
        }
        return result;
    }

    public static void main(String[] args) {
        YHTriangle triangle = new YHTriangle();
        triangle.triangle(triangle.matrix);

    }

}
