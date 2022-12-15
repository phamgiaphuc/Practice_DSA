package com.example.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Case:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 **/

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 2, 11, 15};
        int target = 13;
        TwoSum solution = new TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
