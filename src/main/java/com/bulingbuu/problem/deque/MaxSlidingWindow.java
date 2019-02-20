package com.bulingbuu.problem.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 注意：
 * <p>
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {

        MaxSlidingWindow window = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = window.maxSlidingWindow(nums, 3);
        for (int i:result){
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0||k==0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int max = nums[0];
        for (int i = 0; i < k; i++) {
            deque.addLast(nums[i]);
            max = Math.max(max, nums[i]);
        }
        result[0] = max;
        int x = 1;
        for (int i = k; i < nums.length; i++) {
            int out = deque.poll();
            deque.addLast(nums[i]);
            if (nums[i] > max) {
                max = nums[i];
            } else {
                if (out == max) {
                    //重新计算最大值
                    Iterator<Integer> iterator = deque.iterator();
                    max = iterator.next();
                    while (iterator.hasNext()) {
                        max = Math.max(max, iterator.next());
                    }
                }
            }
            result[x++] = max;
        }


        return result;
    }
}
