/*
Given an array of integers arr[] and an integer target. 
We need to build an expression out of arr[] by 
adding one of the symbols '+' or  '-' before each integer in arr[] and then concatenate all the integers. 
For example : if arr[] = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that can be built, which evaluates to target.

Note : An expression is considered different from another if the placement of '+' and '-' operators differs, even if the resulting value is the same. 

Examples :

Input: arr[] = [1, 1, 1, 1, 1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

Input: arr[] = [1, 2, 3], target = 2
Output: 1
Explanation: There are 1 way to assign symbols to make the sum of nums be target 2(+1 -2 +3). 

Constraints:
1 ≤ arr.size() ≤ 50
1 ≤ arr[i] ≤ 20
0 ≤ sum(arr) ≤ 1000
-1000 ≤ target ≤ 1000
*/


public class TargetSum {
    private static int solve(int arr[], int target, Integer dp[][],  int total, int idx, int sum){
        if(idx == arr.length){
            return sum == target ? 1 : 0;
        }

        int shiftedSum = sum + total;

        if(dp[idx][shiftedSum] != null){
            return dp[idx][shiftedSum];
        }

        int plus = solve(arr, target, dp, total, idx+1, sum + arr[idx]);
        int minus = solve(arr, target, dp, total, idx+1, sum - arr[idx]);

        return dp[idx][shiftedSum] = plus + minus;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 1, 1, 1};
        int target = 3;
        int n = arr.length;
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        if(Math.abs(target) > total) {
            System.out.println(0);
        }
        Integer[][] dp = new Integer[n][2 * total + 1];
        
        System.out.println(solve(arr, target, dp, total, 0, 0));
    }
}
