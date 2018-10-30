package com.bulingbuu.sort;

/**
 * @author bulingbuu
 * @date 18-10-30 下午5:47
 */
public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] array = new int[]{1, 3, 34,2312,2, 5};
        mergeSort.merge_sort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.println(i);
        }

    }


    public void merge_sort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;

        merge_sort(array, p, q);
        merge_sort(array, q + 1, r);

        merge(array, p, r, q);
    }

    /**
     * @param array
     * @param p     数组开始点
     * @param r     数组结束点
     * @param q     数组中间点
     */
    public void merge(int[] array, int p, int r, int q) {
        int i = p, j = q + 1, k = 0;

        int[] tmp = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        int start = i, end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            tmp[k++] = array[start++];
        }
        for (int x = 0; x < tmp.length; x++) {
            array[p + x] = tmp[x];

        }

    }
}
