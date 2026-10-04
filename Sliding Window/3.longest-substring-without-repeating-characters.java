/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (39.28%)
 * Likes:    45248
 * Dislikes: 2224
 * Total Accepted:    9.7M
 * Total Submissions: 24.7M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without duplicate
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3. Note that "bca" and
 * "cab" are also correct answers.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int high = 0; high < n; high++) {
            char ch = s.charAt(high);
            if (map.containsKey(ch)) {
                low = Math.max(low, map.get(ch) + 1);
            }
            map.put(ch, high);
            result = Math.max(result, high - low + 1);
        }
        return result;
    }
}
// @lc code=end
