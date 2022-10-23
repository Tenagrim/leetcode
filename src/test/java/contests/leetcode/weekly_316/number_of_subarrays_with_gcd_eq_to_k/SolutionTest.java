package contests.leetcode.weekly_316.number_of_subarrays_with_gcd_eq_to_k;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution = new Solution();
    @Test
    public void subarrayGCD() {
        assertEquals(4, solution.subarrayGCD(new int[] {9,3,1,2,6,3}, 3));
    }
    @Test
    public void subarrayGCD2() {
        assertEquals(10, solution.subarrayGCD(new int[] {3,3,4,1,2}, 1));
    }
}