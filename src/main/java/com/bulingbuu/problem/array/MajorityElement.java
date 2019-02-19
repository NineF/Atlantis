package com.bulingbuu.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bulingbuu
 * @date 19-2-19 下午6:27
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] ints = {10, 9, 9, 9, 10};
        System.out.println(majorityElement.majorityElement(ints));
        int[] nums = {3, 2, 3};
        for (int i : majorityElement.majorityElement2(nums)) {
            System.out.println(i);
        }
    }

    /**
     * 摩尔投票法
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int ret = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (ret == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    i++;
                    ret = nums[i];
                    count = 1;
                }
            }
        }
        return ret;
    }

    /**
     * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * <p>
     * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
     * 示例 1:
     * <p>
     * 输入: [3,2,3]
     * 输出: [3]
     * 示例 2:
     * <p>
     * 输入: [1,1,1,3,3,2,2,2]
     * 输出: [1,2]
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement2(int[] nums) {
        int ret1 = Integer.MAX_VALUE;
        int ret2 = Integer.MAX_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ret1 == nums[i]) {
                count1++;
            } else if (ret2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                ret1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                ret2 = nums[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        List<Integer> result = new ArrayList<>(2);
        count1=0;
        count2=0;
        for (int i:nums){
            if (ret1==i){
                count1++;
            }else if (ret2==i){
                count2++;
            }
        }
        if (count1>nums.length/3)
            result.add(ret1);
        if (count2>nums.length/3)
            result.add(ret2);

        return result;
    }
}
