/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low=0;
        int sum = 0, result = Integer.MAX_VALUE;
        for(int high=0; high<n; high++){
            sum += nums[high];

            // shrink
            while(sum >= target){
                result = Math.min(result, high - low + 1);
                sum -= nums[low++]; 
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
// @lc code=end

