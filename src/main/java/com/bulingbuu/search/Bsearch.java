package com.bulingbuu.search;

/**
 * @author bulingbuu
 * @date 18-11-7 下午7:08
 * <p>
 * 二分查找
 */
public class Bsearch {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(bsearch(array, 55));
    }

    public static int bsearch(int[] array, int value) {
        int length = array.length;

        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
