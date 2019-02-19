package com.bulingbuu.problem.array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author bulingbuu
 * @date 19-2-19 下午3:37
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * <p>
 * 1.先排序,然后遍历两个正负for循环,二分查找区间内满足条件的数值
 * 2.先排序,然后头尾两个节点相加,比较大小,移动节点
 */
public class ThreeSum {
    public static void main(String[] args) throws IOException {
        ThreeSum threeSum = new ThreeSum();
//        int[] nums = { -1, 0, 1, 2, -1, -4 };
//        int[] nums = { -2, 0, 0, 2, 2 };
//        int[] nums={0,0,0,0};
        int[] nums = { 1, 1, -2 };
        threeSum.threeSum(nums);

    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int index0 = -1;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= 0) {
                index0 = i;
                break;
            }

        }

        int preI = Integer.MIN_VALUE;
        for (int i = 0; i <= index0; i++) {
            if (nums[i] == preI) {
                continue;
            }

            int preK = Integer.MAX_VALUE;
            for (int k = nums.length - 1; k >= index0; k--) {
                if (nums[k] == preK) {
                    continue;
                }

                int tmp = nums[i] + nums[k];
                int x = bsearch(nums, i + 1, k - 1, -tmp);

                if (x != -1) {

                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[x]);
                    list.add(nums[k]);
                    result.add(list);
                }
                preK = nums[k];
            }


            preI = nums[i];
        }

        return result;
    }

    public int bsearch(int[] array, int low, int high, int value) {

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


    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            twoSumHelper(nums, left, right, target, result);

        }


        return result;
    }

    private void twoSumHelper(int[] nums, int left, int right, int target, List<List<Integer>> result) {

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> list = new ArrayList<>(3);
                list.add(-target);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);

                right--;
                left++;


                //去重
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

            } else if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            }

        }


    }

}
