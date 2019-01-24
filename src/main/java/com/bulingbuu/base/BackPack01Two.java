package com.bulingbuu.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bulingbuu
 * @date 19-1-22 下午8:50
 * <p>
 * 01背包进阶版
 */
@Setter
@Getter
@NoArgsConstructor
public class BackPack01Two {
    //最大重量
    private int maxW;
    //数组长度
    private int length;

    private int[] weight;

    private int[] value;

    private int result;
    //备忘录
    boolean[][] mem;

    int[][] data;
    int[] data1;

    private void init() {
        mem = new boolean[length][maxW];
        data = new int[length][maxW + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= maxW; j++) {
                data[i][j] = -1;
            }
        }

        data1 = new int[maxW + 1];
        for (int i = 0; i <= maxW; i++) {
            data1[i] = -1;
        }
    }

    public void clear() {
        result = -1;
        mem = new boolean[length][maxW];
    }

    /**
     * 回溯第一版
     *
     * @param ob
     * @param cw
     * @param cv
     */
    public void backTrack1(int ob, int cw, int cv) {

        //放入完毕,或者已经达到了最大重量
        if (ob == length || cw == maxW) {
            if (cv > result) {
                result = cv;
            }
            return;
        }

        //第一个不放
        backTrack1(ob + 1, cw, cv);

        //放入后小于最大值
        if (cw + weight[ob] <= maxW) {
            //放入第二个
            backTrack1(ob + 1, cw + weight[ob], cv + value[ob]);
        }
    }

    /**
     * 动态规划第一种实现
     */
    public void dynamicPlanning() {
        data[0][0] = 0;
        data[0][weight[0]] = value[0];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= maxW; j++) {
                if (data[i - 1][j] > -1) {
                    //不放入,原来可能存在值,选择两者大的
                    data[i][j] = data[i][j] > data[i - 1][j]? data[i][j] : data[i - 1][j];

                    //放入
                    if (j + weight[i] <= maxW) {
                        data[i][j + weight[i]] = data[i - 1][j] + value[i];
                    }
                }
            }
        }

        int result = -1;
        for (int i = maxW; i > 0; i--) {
            if (data[length - 1][i] > result) {
                result = data[length - 1][i];
            }
        }
        System.out.println(result);

    }

    public void dynamicPlanning1() {
        data1[0] = 0;
        data1[weight[0]] = value[0];

        for (int i = 1; i < length; i++) {
            for (int j = maxW - weight[i]; j >= 0; j--) {
                if (data1[j] > 0) {
                    if (data1[j + weight[i]] < data1[j] + value[i]) {
                        data1[j + weight[i]] = data1[j] + value[i];
                    }
                }
            }
        }
        int result = -1;
        for (int i = maxW; i > 0; i--) {
            if (data1[i] > result) {
                result = data1[i];
            }
        }
        System.out.println(result);
    }


    public static void main(String[] args) {
        BackPack01Two backPack01Two = new BackPack01Two();
        backPack01Two.setMaxW(10);
        int[] weight = { 2, 2, 4, 6, 3 };
        int[] value = { 3, 4, 8, 9, 6 };
        backPack01Two.setWeight(weight);
        backPack01Two.setLength(weight.length);
        backPack01Two.setValue(value);
        backPack01Two.init();

        backPack01Two.backTrack1(0, 0, 0);
        System.out.println(backPack01Two.getResult());
        backPack01Two.dynamicPlanning();
        backPack01Two.dynamicPlanning1();
    }
}
