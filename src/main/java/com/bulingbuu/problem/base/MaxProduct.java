package com.bulingbuu.problem.base;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {
    public static void main(String[] args) {
        MaxProduct product = new MaxProduct();
        int[] nums = {2, 3, -2, 4, -2,1};
        System.out.println(product.maxProduct1(nums));

    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int x = nums[0];
        for (int i = 1; i < length; i++) {
            x *= nums[i];
            if (x == 0) x = nums[i];
            max = Math.max(max, Math.max(x, nums[i]));
        }
        x = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            x *= nums[i];
            if (x == 0) x = nums[i];
            max = Math.max(max, Math.max(x, nums[i]));
        }
        return max;
    }

    /**
     * 上一步的最大值 * 当前（正）值
     * 上一步的最小值 * 当前（负）值
     * 当前值
     *
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int minDp = nums[0];
        int maxDp = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = maxDp * nums[i];
            int b = minDp * nums[i];
            maxDp = Math.max(Math.max(a, b), nums[i]);
            minDp = Math.min(Math.min(a, b), nums[i]);
            res = Math.max(res, maxDp);

        }
        return res;
    }

}
