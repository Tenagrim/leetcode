package medium.count_and_say;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void countAndSay() {
        assertEquals("312211", solution.countAndSay(6));
    }
}