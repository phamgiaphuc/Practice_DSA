package com.example.leetcode.twopointers;

/**
 * 392. Is Subsequence
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 */

public class IsSubsequence {
    String source, target;
    Integer left_bound, right_bound;

    public static void main(String[] args) {
        IsSubsequence solution = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        solution.IsSubsequence(s, t);
        System.out.println(solution.check_isSubsequence_1(0,0));
        System.out.println(solution.check_isSubsequence_2());
    }

    public void IsSubsequence (String s, String t) {
        this.source = s;
        this.target = t;
        this.left_bound = s.length();
        this.right_bound = t.length();
    }

    // Solution 1
    private boolean check_isSubsequence_1(int left_index, int right_index) {
        if (right_index == right_bound) return false;
        if(source.charAt(left_index) == target.charAt(right_index)) {
            left_index++;
            if (left_index == left_bound) return true;
        }
        right_index++;
        return check_isSubsequence_1(left_index, right_index);
    }

    // Solution 2
    private boolean check_isSubsequence_2() {
        int left_point = 0;
        int right_point = 0;
        while (left_point < left_bound && right_point < right_bound) {
            if (source.charAt(left_point) == target.charAt(right_point)) {
                left_point++;
            }
            right_point++;
        }
        return left_point == left_bound;
    }
}
