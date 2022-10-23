package medium.find_the_duplicate_number;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final  Solution solution = new Solution();
    @Test
    public void findDuplicate() {
        assertEquals(2, solution.findDuplicate(new int[]{1,3,4,2,2}));
    }
    @Test
    public void findDuplicate2() {
        assertEquals(1, solution.findDuplicate(new int[]{1,3,4,1,2}));
    }
    @Test
    public void findDuplicate3() {
        assertEquals(3, solution.findDuplicate(new int[]{1,3,4,3,2}));
    }
    @Test
    public void findDuplicate4() {
        assertEquals(9, solution.findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
    @Test
    public void findDuplicate5() {
        assertEquals(1, solution.findDuplicate(new int[]{1, 2, 1}));
    }
}