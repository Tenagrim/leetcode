package medium.three_sum_closest;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int closest = nums[0] + nums[1] + nums[2], suspect, dist;
        if (len == 3) return closest;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (i!=j&&i!=k&&j!=k){
                        suspect = nums[i] + nums[j] + nums[k];
                        dist = Math.abs(target - suspect);
                        if (dist == 0)
                            return suspect;
                        else if (Math.abs(target -closest) > dist) {
                            closest = suspect;
                        }
                    }
                }
            }
        }
        return closest;
    }
}
