package com.bulingbuu.sort;

/**
 * @author bulingbuu
 * @date 18-10-30 下午7:35
 */
public class NumKth {

    public static void main(String[] args) {
        NumKth numKth = new NumKth();

        int[] array = new int[]{1, 3, 34, 2312, 2, 5};
        int k = numKth.quick_sort(array, 0, array.length - 1, 6);
        System.out.println(k);


    }


    public int quick_sort(int[] array, int p, int r, int k) {

        int q = partition(array, p, r);
        if (q + 1 == k) {
            return array[q];
        } else if (q + 1 < k) {
            return quick_sort(array, q + 1, r, k);
        } else {
            return quick_sort(array, p, q - 1, k);
        }

    }

    public int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (array[j] < pivot) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                i++;
            }
        }

        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;

        return i;
    }


}
