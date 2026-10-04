/*
 * @lc app=leetcode id=904 lang=java
 *
 * [904] Fruit Into Baskets
 */

// @lc code=start

import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0, result = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int high = 0; high < n; high++) {
            map.put(fruits[high], map.getOrDefault(fruits[high], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[low], map.get(fruits[low]) - 1);
                if (map.get(fruits[low]) == 0) {
                    map.remove(fruits[low]);
                }
                low++;
            }
            result = Math.max(result, high - low + 1);
        }
        return result;
    }
}
// @lc code=end
