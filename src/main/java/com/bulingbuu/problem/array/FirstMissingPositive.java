package com.bulingbuu.problem.array;

/**
 * @author bulingbuu
 * @date 19-2-20 上午9:31
 * <p>
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 说明:
 * <p>
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
 * <p>
 * 取出数组中的所有正数(0-k)
 * 然后遍历正数,判断当前正数是否超出k,如果超出,则不处理,如果不超出
 * 则将当前正数做为index,将对应index里面的数置反(这样可以保留原始数据)
 * 遍历0-k,获取大于0的数对应的index,就是结果
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive positive = new FirstMissingPositive();
        int[] nums = { 2, 4, -1, 1 };
        System.out.println(positive.firstMissingPositive(nums));

    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 1;
        }

        int k = partition(nums) + 1;
        int first_missing_Index = k;
        for (int i = 0; i < k; i++) {
            int temp = Math.abs(nums[i]);
            if (temp <= k) {
                nums[temp - 1] = (nums[temp - 1] < 0)? nums[temp - 1] : -nums[temp - 1];
            }
        }

        for (int i = 0; i < k; i++) {
            if (nums[i] > 0) {
                first_missing_Index = i;
                break;
            }
        }
        return first_missing_Index + 1;
    }

    public int partition(int[] nums) {
        int p = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                p++;
                swap(nums, p, i);
            }
        }
        return p;
    }

    public void swap(int[] A, int i, int j) {
        if (i != j) {
            A[i] ^= A[j];
            A[j] ^= A[i];
            A[i] ^= A[j];
        }
    }
}
