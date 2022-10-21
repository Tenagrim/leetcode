package easy.contains_duplicate_ii;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0)return false;
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (map.containsKey(cur) && Math.abs(i - map.get(cur)) <= k)
                return true;
            else
                map.put(cur,i);
        }
        return false;
    }
}
