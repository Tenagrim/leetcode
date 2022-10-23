package contests.leetcode.weekly_316.number_of_subarrays_with_gcd_eq_to_k;

import java.math.BigInteger;

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            BigInteger gcd = BigInteger.ZERO;
            for (int j = i; j < nums.length; j++) {
                if ((gcd = gcd.gcd(BigInteger.valueOf(nums[j]))).intValue() == k )
                    count++;
            }
        }
        return count;
    }
}
