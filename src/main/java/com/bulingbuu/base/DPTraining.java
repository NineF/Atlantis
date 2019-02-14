package com.bulingbuu.base;

/**
 * @author bulingbuu
 * @date 19-2-13 下午6:14
 */
public class DPTraining {
    int[] coins = { 3, 5 };

    public void change(int money) {
        int[] item = new int[money + 1];
        item[0] = 0;


        for (int i = 1; i < money + 1; i++) {
            item[i] = -1;
        }

        for (int i = 1; i < money + 1; i++) {
            int minItem = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {

                if (i - coins[j] >= 0 && item[i - coins[j]] != -1) {
                    minItem = Math.min(minItem, item[i - coins[j]]);
                }
            }
            if (minItem != Integer.MAX_VALUE) {
                item[i] = minItem + 1;
            }
        }
        System.out.println(item[money]);
    }

    int[] datas = { 2, 9, 3, 8, 7, 6, 18 };

    /**
     * 查找最大递增子串
     *
     * @param datas
     */
    public void increment(int[] datas) {
        int[] item = new int[datas.length];
        for (int i = 0; i < datas.length; i++) {
            item[i] = 1;
        }

        for (int i = 1; i < datas.length; i++) {
            int k = i - 1;
            int tmp = 1;
            while (k >= 0) {
                if (datas[i] > datas[k]) {
                    tmp = Math.max(item[k] + 1, tmp);
                    break;
                }
                tmp = Math.max(item[k], tmp);
                k--;
            }
            item[i] = tmp;
        }

        System.out.println(item[datas.length - 1]);
    }

    public static void main(String[] args) {
        DPTraining training = new DPTraining();
//        training.change(25);
        training.increment(training.datas);
    }

}
