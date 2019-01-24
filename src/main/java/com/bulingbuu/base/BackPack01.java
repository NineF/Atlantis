package com.bulingbuu.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bulingbuu
 * @date 19-1-22 下午7:45
 * <p>
 * 01背包基础版
 */
@Setter
@Getter
@NoArgsConstructor
public class BackPack01 {
    //最大重量
    private int maxW;
    //数组长度
    private int length;

    private int[] weight;
    //结果
    private int result;
    //备忘录
    boolean[][] mem;

    int[][] data;
    int[] data1;

    private void init() {
        mem = new boolean[length][maxW];
        data = new int[length][maxW + 1];
        data1 = new int[maxW + 1];
    }

    public void clear() {
        result = -1;
        mem = new boolean[length][maxW];
    }


    /**
     * 回溯实现第一版
     *
     * @param ob
     * @param cw
     */
    public void backTrack1(int ob, int cw) {

        //放入完毕,或者已经达到了最大重量
        if (ob == length || cw == maxW) {
            if (cw > result) {
                result = cw;
            }
            return;
        }

        //第一个不放
        backTrack1(ob + 1, cw);

        //放入后小于最大值
        if (cw + weight[ob] <= maxW) {
            //放入第二个
            backTrack1(ob + 1, cw + weight[ob]);
        }
    }


    /**
     * 回溯实现第二版(添加备忘录)
     *
     * @param ob
     * @param cw
     */
    public void backTrack2(int ob, int cw) {
        //放入完毕,或者已经达到了最大重量
        if (ob == length || cw == maxW) {
            if (cw > result) {
                result = cw;
            }
            return;
        }
        //有这个状态了
        if (mem[ob][cw]) {
            return;
        }
        //记录这个状态
        mem[ob][cw] = true;
        //第一个不放
        backTrack2(ob + 1, cw);

        //放入后小于最大值
        if (cw + weight[ob] <= maxW) {
            //放入第二个
            //第一个不放
            backTrack2(ob + 1, cw + weight[ob]);
        }
    }


    /**
     * 动态规划实现1
     */
    public void dynamicPlanning() {
        //哨兵
        data[0][0] = 1;
        data[0][weight[0]] = 1;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j <= maxW; j++) {
                if (data[i - 1][j] == 1) {
                    //放入第一个
                    data[i][j] = 1;

                    //放入第二个
                    //加上后没达到最大值
                    if (j + weight[i] <= maxW) {
                        data[i][j + weight[i]] = 1;
                    }
                }
            }

//            for (int j=0;j+weight[i]<=maxW;j++){
//                if (data[i - 1][j] == 1){
//                    data[i][j + weight[i]] = 1;
//                }
//            }
        }
        for (int i = maxW; i > 0; --i) {
            if (data[length - 1][i] == 1) {
                System.out.println(i);
                return;
            }
        }

    }

    /**
     * 动态规划第二种实现
     */
    public void dynamicPlanning2() {
        //哨兵
        data1[0] = 1;
        data1[weight[0]] = 1;

        for (int i = 1; i < length; i++) {
            //这里必须从大到小,避免重复计算导致数据不准确
            for (int j = maxW - weight[i]; j >= 0; j--) {
                if (data1[j] == 1) {
                    //放入第二个
                    data1[j + weight[i]] = 1;
                }
            }
        }

        for (int i = maxW; i > 0; i--) {
            if (data1[i] == 1) {
                System.out.println(i);
                return;
            }
        }

    }


    public static void main(String[] args) {
        BackPack01 backPack01 = new BackPack01();
        backPack01.setMaxW(14);
        int[] weight = { 3, 2, 4, 6 };
        backPack01.setWeight(weight);
        backPack01.setLength(weight.length);
        backPack01.init();

        backPack01.backTrack1(0, 0);
        System.out.println(backPack01.getResult());
        backPack01.clear();
        backPack01.backTrack2(0, 0);
        System.out.println(backPack01.getResult());

        backPack01.dynamicPlanning();
        backPack01.dynamicPlanning2();
    }
}
