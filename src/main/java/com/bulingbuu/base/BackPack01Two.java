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

    private void init() {
        mem = new boolean[length][maxW];
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

    }
}
