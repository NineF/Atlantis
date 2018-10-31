package com.bulingbuu.sort;

/**
 * @author bulingbuu
 * @date 18-10-31 上午11:35
 * 计数排序
 */
public class CountingSort {

    public static void main(String[] args) {

        CountingSort countingSort=new CountingSort();
        int[] array = new int[]{1, 3, 4, 7, 2, 5};
        countingSort.countingSort(array);
        for (int a:array){
            System.out.println(a);
        }

    }

    /**
     * 计数排序，a 是数组.假设数组中存储的都是非负整数
     *
     * @param array
     */
    public void countingSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        //获取区间最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }

        }
        //初始化
        int[] bucket = new int[max + 1];
//        for (int i = 0; i <= max; i++) {
//            bucket[i] = 0;
//        }
        //放入桶中,统计每个元素数量
        for (int x : array) {
            bucket[x]++;
        }
        //依次相加
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        int[] tmp = new int[array.length];

        for (int a : array) {
            //bucket[a]->小于a的个数;-1就是元素最终位置
            int index = bucket[a] - 1;
            tmp[index] = a;
            //移除后减掉一个元素
            bucket[a]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

}
