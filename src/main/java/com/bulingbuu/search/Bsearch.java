package com.bulingbuu.search;

/**
 * @author bulingbuu
 * @date 18-11-7 下午7:08
 * <p>
 * 二分查找
 */
public class Bsearch {

    public static void main(String[] args) {
        int[] array = new int[]{4,5,6, 1,2,3};
//        System.out.println(bsearch(array, 55));
//        System.out.println(bsearchV1(array, 5));
        System.out.println(xhBsearch(array, 5));
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


    public static int bsearchV1(int[] array, int value) {
        int length = array.length;

        int low = 0;
        int high = length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == value) {
                while (mid >= 0) {
                    if (array[mid] != value) {
                        mid++;
                        break;
                    }
                    mid--;
                }
                return mid;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int xhBsearch(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左边有序
            if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && nums[mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //右边有序
            else {
                if (nums[mid] <= target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
}
