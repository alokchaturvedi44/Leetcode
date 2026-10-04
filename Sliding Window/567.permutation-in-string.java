/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 *
 * algorithms
 * Medium (49.09%)
 * Likes:    13122
 * Dislikes: 524
 * Total Accepted:    1.5M
 * Total Submissions: 3.1M
 * Testcase Example:  '"ab"\n"eidbaooo"'
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 * 
 * In other words, return true if one of s1's permutations is the substring of
 * s2.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s1.length, s2.length <= 10^4
 * s1 and s2 consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m > n) return false;
        int sFreq[] = new int[26];
        int tFreq[] = new int[26];
        for (int i = 0; i < m; i++) {
            sFreq[s.charAt(i) - 'a']++;
            tFreq[t.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sFreq, tFreq)){
            return true;
        }
        for(int i=m; i<n; i++){
            tFreq[t.charAt(i-m) - 'a']--;
            tFreq[t.charAt(i) - 'a']++;
            if(Arrays.equals(sFreq, tFreq)){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end
