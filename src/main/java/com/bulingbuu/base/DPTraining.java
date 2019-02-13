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

    public static void main(String[] args) {
        DPTraining training = new DPTraining();
        training.change(25);

    }

}
