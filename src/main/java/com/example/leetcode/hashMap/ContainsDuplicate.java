package com.example.leetcode.hashMap;

import java.util.HashMap;

/**
 * 217. Contains Duplicate
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: true
 */

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        ContainsDuplicate solution = new ContainsDuplicate();
        System.out.println(solution.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
