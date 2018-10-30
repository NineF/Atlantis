package com.bulingbuu.sort;

/**
 * @author bulingbuu
 * @date 18-10-30 下午7:19
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        int[] array = new int[]{1, 3, 34,2312,2, 5};
        quickSort.quick_sort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.println(i);
        }

    }
    public void quick_sort(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(array, p, r);
        quick_sort(array, p, q - 1);
        quick_sort(array, q + 1, r);
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
