/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 *
 * https://leetcode.com/problems/happy-number/description/
 *
 * algorithms
 * Easy (59.81%)
 * Likes:    12032
 * Dislikes: 1648
 * Total Accepted:    2.3M
 * Total Submissions: 3.9M
 * Testcase Example:  '19'
 *
 * Write an algorithm to determine if a number n is happy.
 * 
 * A happy number is a number defined by the following process:
 * 
 * 
 * Starting with any positive integer, replace the number by the sum of the
 * squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it
 * loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * 
 * 
 * Return true if n is a happy number, and false if not.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 2
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
class Solution {
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            sum += rem * rem;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getSum(slow);
            fast = getSum(getSum(fast));
        } while (slow != fast);

        return slow == 1;
    }
}
// @lc code=end
