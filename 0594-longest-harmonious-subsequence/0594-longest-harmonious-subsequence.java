import java.util.*;

class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();

        // count frequency
        for(int x : nums){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int maxLen = 0;

        for(int key : map.keySet()){
            if(map.containsKey(key+1)){
                maxLen = Math.max(maxLen,
                        map.get(key) + map.get(key+1));
            }
        }

        return maxLen;
    }
}
