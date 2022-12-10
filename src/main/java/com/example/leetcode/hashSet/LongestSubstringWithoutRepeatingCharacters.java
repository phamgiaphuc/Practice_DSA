package com.example.leetcode.hashSet;

/*
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        String test = "abb";
        // Solution 1
        System.out.println(solution.lengthOfLongestSubstring_1(test));
        // Solution 2
        System.out.println(solution.lengthOfLongestSubstring_2(test));
        // Solution 3
        System.out.println(solution.lengthOfLongestSubstring_3(test));
        // Solution 4
        System.out.println(solution.lengthOfLongestSubstring_4(test));
    }

    // Solution 1: Brute Force
    public int lengthOfLongestSubstring_1(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (checkRepetition(s, i, j)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    private boolean checkRepetition(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            char temp = s.charAt(i);
            if (set.contains(temp)) {
                return false;
            }
            set.add(temp);
        }
        return true;
    }

    // Solution 2: Sliding Window
    // Explanation for the map:
    // {a=1}
    // {a=1, b=1}
    // {a=1, b=2}
    // {a=0, b=2}
    // {a=0, b=1}
    public int lengthOfLongestSubstring_2(String s) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char a = s.charAt(right);
            map.put(a, map.getOrDefault(a, 0) + 1);
            //System.out.println(map);
            while (map.get(a) > 1) {
                char b = s.charAt(left);
                map.put(b, map.get(b) - 1);
                //System.out.println(map);
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }


    // Solution 3: Sliding Window Optimized
    // Explanation for the map:
    // {a=1}
    // {a=1, b=2}
    // {a=1, b=3}
    public int lengthOfLongestSubstring_3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
            //System.out.println(map);
        }
        return ans;
    }

    // Solution 4
    public int lengthOfLongestSubstring_4(String s) {
        int longestSubLength = 0;
        StringBuilder longestSubString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (longestSubString.toString().indexOf(s.charAt(i)) == -1) {
                //not in string yet
                longestSubString.append(s.charAt(i));
            } else {
                if (longestSubString.length() > longestSubLength) {
                    longestSubLength = longestSubString.length();
                }
                int index = longestSubString.toString().indexOf(s.charAt(i));
                //find where to start the new substring
                longestSubString = new StringBuilder(longestSubString.substring(index + 1, longestSubString.length()) + s.charAt(i));
            }
        }
        return Math.max(longestSubString.length(), longestSubLength);
    }
}


