package contests.leetcode.weekly_316.determine_if_two_events_have_conflict;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void haveConflict() {
        assertTrue(solution.haveConflict(new String[]{"01:00","02:00"}, new String[]{"01:20","03:00"}));
    }
    @Test
    public void haveConflict2() {
        assertFalse(solution.haveConflict(new String[]{"10:00","11:00"}, new String[]{"14:00","15:00"}));
    }
}