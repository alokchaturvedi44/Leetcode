/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (59.91%)
 * Likes:    13243
 * Dislikes: 773
 * Total Accepted:    1.6M
 * Total Submissions: 2.7M
 * Testcase Example:  '"ABAB"\n2'
 *
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you
 * can get after performing the above operations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 * 
 * 
 */

// @lc code=start

import java.util.*;

class Solution {
    private int solve(int freq[]){
        int ans = -1;
        for(int i : freq){
            ans = Math.max(ans, i);
        }
        return ans;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low=0, result=0;
        int freq[] = new int[256];

        for(int high=0; high<n; high++){
            char ch = s.charAt(high);
            freq[ch]++;
            int len = high - low + 1;
            int maxFreq = solve(freq);
            int diff = len - maxFreq;
            while(diff > k){
                char c = s.charAt(low++);
                freq[c]--;
                maxFreq = solve(freq);
                diff = high - low + 1 - maxFreq;
            }
            result = Math.max(result, high-low+1);
        }
        return result;
    }
}
// @lc code=end

