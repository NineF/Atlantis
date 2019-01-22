package com.bulingbuu.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author bulingbuu
 * @date 19-1-22 下午7:45
 * <p>
 * 01背包,回溯实现
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

    private void init() {
        mem = new boolean[length][maxW];
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

    }
}
