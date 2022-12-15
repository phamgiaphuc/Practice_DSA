package com.example.leetcode.arrays;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }

    // Solution
    public boolean isAnagram(String s, String t) {
        char[]a = s.toCharArray();
        char[]b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }
}
