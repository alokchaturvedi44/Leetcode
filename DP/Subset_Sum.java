/*
Given an array of positive integers arr[] and a value sum, find if there is a subset of arr[] with sum equal to given sum. 

Examples:

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9
Output: true 
Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.

Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 30
Output: false
Explanation: There is no subset with target sum 30.

Input: arr[] = [1, 2, 3], sum = 6
Output: true
Explanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.

Constraints:
1 ≤ arr.size(), arr[i] ≤ 200
1 ≤ sum ≤ 104 */

import java.util.*;

class Subset_Sum {

    private static boolean solve(int arr[], int target, int idx, Boolean dp[][]){
        if(target == 0)
            return true;

        if(idx == arr.length)
            return false;

        if(dp[idx][target] != null)
            return dp[idx][target];

        boolean take = false;
        if(arr[idx] <= target)
            take = solve(arr, target - arr[idx], idx+1, dp);

        boolean leave = solve(arr, target, idx+1, dp);

        return dp[idx][target] = take || leave;
    }
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        int n = arr.length;

        Boolean dp[][] = new Boolean[n][sum + 1];

        System.out.println(solve(arr, sum, 0, dp));

        // approach - 2
        boolean dp2[] = new boolean[sum + 1];
        dp2[0] = true;

        for(int i=0; i<n; i++){
            for(int target=sum; target>=arr[i]; target--){
                dp2[target] = dp2[target] || dp2[target - arr[i]];
            }
        }
        System.out.println(dp2[sum]);
    }
}
