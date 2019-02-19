package com.bulingbuu.practice.array;

/**
 * @author bulingbuu
 * @date 19-2-18 下午5:08
 * 一个大小固定的有序数组,支持动态增删改查
 *
 * 未完成
 */
public class SortArray {
    private int[] array;
    private int maxSize;
    private int current;

    public SortArray() {
        this(4);
    }

    public SortArray(int size) {
        array = new int[size];
        this.maxSize = size;
    }

    public boolean add(int value) {
        if (current >= maxSize - 1) {
            System.out.println("已满");
            return false;
        }


        return false;
    }

    /**
     * 2分查找出位置
     *
     * @param value
     *
     * @return
     */
    private int binarySearch(int value) {
        int low = 0;
        int high = current;

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
