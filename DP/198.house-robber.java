/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 *
 * https://leetcode.com/problems/house-robber/description/
 *
 * algorithms
 * Medium (53.32%)
 * Likes:    23988
 * Dislikes: 534
 * Total Accepted:    3.9M
 * Total Submissions: 7.3M
 * Testcase Example:  '[1,2,3,1]'
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping
 * you from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent
 * houses were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house
 * 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 
 * 
 */

// @lc code=start
class Solution {

    private int solve1(int nums[], int dp[][], int idx, int canRob){
        if(idx == nums.length) return 0;

        if(dp[idx][canRob] != -1){
            return dp[idx][canRob];
        }
        if(canRob == 0){
            return dp[idx][canRob] = solve1(nums, dp, idx+1, 1);
        }

        int take = nums[idx] + solve1(nums, dp, idx+1, 0);
        int leave = solve1(nums, dp, idx+1, 1);

        return dp[idx][canRob] = Math.max(take, leave);
    }

    private int solve2(int nums[]){
        int n = nums.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<n+1; i++){
            int take = nums[i-1] + dp[i-2];
            int leave = dp[i-1];
            
            dp[i] = Math.max(take, leave);
        }

        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;

        // approach - 1

        int dp[][] = new int[n+1][2];
        for(int i=0; i<n+1; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        // return solve1(nums, dp, 0, 1);

        // approach - 2
        return solve2(nums);
    }
}
// @lc code=end

