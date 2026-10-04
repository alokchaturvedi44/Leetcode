import java.util.*;

public class Longest_Substr_K_Unq{
    public static int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int low=0, result=-1;
        
        for(int high=0; high<n; high++){
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // shrinking
            while(map.size() > k){
                char c = s.charAt(low++);
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0){
                    map.remove(c);
                }
            }
            if(map.size() == k){
                result = Math.max(result, high-low+1);
            }
        }
        return result;
    }
}
