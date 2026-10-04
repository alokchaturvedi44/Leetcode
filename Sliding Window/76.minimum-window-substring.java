/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (47.78%)
 * Likes:    20390
 * Dislikes: 860
 * Total Accepted:    2.2M
 * Total Submissions: 4.7M
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given two strings s and t of lengths m and n respectively, return the
 * minimum window substring of s such that every character in t (including
 * duplicates) is included in the window. If there is no such substring, return
 * the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C'
 * from string t.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 10^5
 * s and t consist of uppercase and lowercase English letters.
 * 
 * 
 * 
 * Follow up: Could you find an algorithm that runs in O(m + n) time?
 * 
 */

// @lc code=start
class Solution {
    private boolean isSame(int sFreq[], int tFreq[]){
        for(int i=0; i<256; i++){
            if(sFreq[i] < tFreq[i]){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int sFreq[] = new int[256];
        int tFreq[] = new int[256];
        for(int i=0; i<n; i++){
            tFreq[t.charAt(i)]++;
        }

        int low=0, strt=-1, result=Integer.MAX_VALUE;

        for(int high=0; high<m; high++){
            sFreq[s.charAt(high)]++;
            while(isSame(sFreq, tFreq)){
                int currLen = high-low+1;
                if(currLen < result){
                    result = currLen;
                    strt = low;
                }
                sFreq[s.charAt(low)]--;
                low++;
            }
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(strt, strt + result);
    }
}
// @lc code=end

