/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 *
 * algorithms
 * Medium (53.94%)
 * Likes:    13300
 * Dislikes: 378
 * Total Accepted:    1.2M
 * Total Submissions: 2.3M
 * Testcase Example:  '"cbaebabacd"\n"abc"'
 *
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 * 
 * 
 */

// @lc code=start

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> list = new ArrayList<>();

        if (n > m)
            return list;

        int sFreq[] = new int[26];
        int pFreq[] = new int[26];
        for (int i = 0; i < n; i++) {
            pFreq[p.charAt(i) - 'a']++;
            sFreq[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sFreq, pFreq)) {
            list.add(0);
            // return list;
        }

        // int low=0, idx=-1;
        for (int i = n; i < m; i++) {
            sFreq[s.charAt(i - n) - 'a']--;
            sFreq[s.charAt(i) - 'a']++;
            if (Arrays.equals(sFreq, pFreq)) {
                list.add(i - n + 1);
            }
        }
        return list;
    }
}
// @lc code=end
