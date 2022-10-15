package contests.leetcode.biweekly_89.number_of_valid_clock_times;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void countTime() {
        assertEquals(2, solution.countTime("?5:00"));
        assertEquals(2, solution.countTime("?4:22"));
        assertEquals(100, solution.countTime("0?:0?"));
        assertEquals(1440, solution.countTime("??:??"));
        assertEquals(6, solution.countTime("07:?3"));
        assertEquals(240, solution.countTime("2?:??"));
    }
}