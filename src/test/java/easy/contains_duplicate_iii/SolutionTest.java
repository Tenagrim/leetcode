package easy.contains_duplicate_iii;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void containsNearbyAlmostDuplicate0() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
    }@Test
    public void containsNearbyAlmostDuplicate() {
        assertTrue(solution.containsNearbyAlmostDuplicate(new int[]{8,7,15,1,6,1,9,15}, 1, 3));
    }
    @Test
    public void containsNearbyAlmostDuplicate2() {
        assertFalse(solution.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }
}