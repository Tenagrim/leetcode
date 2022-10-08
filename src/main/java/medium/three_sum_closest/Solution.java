package medium.three_sum_closest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int  len = nums.length, closest = nums[0] + nums[1] + nums[len-1];
        Arrays.sort(nums); // O(NlogN)
        for (int i = 0; i < len -2; i++) {
            int first = nums[i], second_ind = i + 1, third_ind = len-1, sum;
            do{
                sum = first + nums[second_ind] + nums[third_ind];
                if (Math.abs(target - sum) < Math.abs(target - closest) || sum == target)
                    closest = sum;
                if (sum < closest)
                    second_ind ++;
                else
                    third_ind--;
            }while (second_ind < third_ind  && sum != target);
        }
        return closest;
    }
}
