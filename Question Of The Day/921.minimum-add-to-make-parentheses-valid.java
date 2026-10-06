/*
 * @lc app=leetcode id=921 lang=java
 *
 * [921] Minimum Add to Make Parentheses Valid
 *
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 *
 * algorithms
 * Medium (74.37%)
 * Likes:    5144
 * Dislikes: 257
 * Total Accepted:    790.1K
 * Total Submissions: 1.1M
 * Testcase Example:  '"())"'
 *
 * A parentheses string is valid if and only if:
 * 
 * 
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid
 * strings, or
 * It can be written as (A), where A is a valid string.
 * 
 * 
 * You are given a parentheses string s. In one move, you can insert a
 * parenthesis at any position of the string.
 * 
 * 
 * For example, if s = "()))", you can insert an opening parenthesis to be
 * "(()))" or a closing parenthesis to be "())))".
 * 
 * 
 * Return the minimum number of moves required to make s valid.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "())"
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "((("
 * Output: 3
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 1000
 * s[i] is either '(' or ')'.
 * 
 * 
 */

// @lc code=start

import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    ans++;
                }
            }
        }
        return ans + st.size();
        // int ans = 0;
        // int open = 0;
        // for(char ch : s.toCharArray()){
        // if(ch == '('){
        // open++;
        // }
        // else{
        // if(open > 0){
        // open--;
        // }
        // else{
        // ans++;
        // }
        // }
        // }
        // return open + ans;
    }
}
// @lc code=end
