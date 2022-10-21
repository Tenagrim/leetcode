package easy.contains_duplicate_iii;

import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            Integer num = nums[i];
            Integer ceil = set.ceiling(num);
            Integer floor = set.floor(num);
            if(ceil != null && Math.abs(ceil - num) <= valueDiff)
                return true;
            if(floor != null && Math.abs(floor - num) <= valueDiff)
                return true;
            set.add(num);

            if (set.size() > indexDiff)
                set.remove(nums[i - indexDiff]);
        }
        return false;
    }

}
