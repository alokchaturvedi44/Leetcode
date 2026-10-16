/*
Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and 
an integer W representing the maximum capacity of the knapsack (the total weight it can hold).

Put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.

Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. 
Each item is available only once.

Examples :

Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]
Output: 3
Explanation: Choose the last item, which weighs 1 unit and has a value of 3.

Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] 
Output: 0
Explanation: Every item has a weight exceeding the knapsack's capacity (3).

Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] 
Output: 80
Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

Constraints:
1 ≤ W, val.size(), val[i], wt.size(), wt[i] ≤ 103
wt.size() = val.size()
*/
import java.util.*;

class Knapsack {

    private static int solve(int cap, int val[], int wt[], int dp[][], int idx){
        if(idx == val.length || cap == 0) return 0;
        
        if(dp[idx][cap] != -1){
            return dp[idx][cap];
        }
        
        int take = 0;

        if(wt[idx] <= cap){
            take = val[idx] + solve(cap - wt[idx], val, wt, dp, idx+1);
        }
        int leave = solve(cap, val, wt, dp, idx+1);
        
        return dp[idx][cap] = Math.max(take, leave);
    }
    public static void main(String[] args) {
        int capacity = 5;
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 2, 3};

        int n = val.length;

        int dp[][] = new int[n + 1][capacity + 1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<capacity+1; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(capacity, val, wt, dp, 0));
    }
}
