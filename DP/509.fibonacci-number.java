/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 *
 * https://leetcode.com/problems/fibonacci-number/description/
 *
 * algorithms
 * Easy (74.25%)
 * Likes:    9599
 * Dislikes: 424
 * Total Accepted:    3.4M
 * Total Submissions: 4.6M
 * Testcase Example:  '2'
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * 
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * 
 * 
 * Given n, calculate F(n).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= n <= 30
 * 
 * 
 */

// @lc code=start
import java.util.*;

class Solution {
    private int solve(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = solve(n - 1, dp) + solve(n - 2, dp);

        return dp[n];
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        // int dp[] = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // for (int i = 2; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];


        // space optimized approach
        int prev_prev = 0;
        int prev = 1;
        for(int i=2; i<n+1; i++){
            int ans = prev + prev_prev;
            prev_prev = prev;
            prev = ans;
        }
        // return prev;

        // recursive dp approach
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);



        
    }
}
// @lc code=end
