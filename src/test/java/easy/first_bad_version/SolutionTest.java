package easy.first_bad_version;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void firstBadVersion() {
        solution.setBadVersion(4);

    }

    @Test
    public void testFirstBadVersion() {
        solution.setBadVersion(4);
        assertEquals(4, solution.firstBadVersion(5));
        System.out.println("calls : " + solution.getCalls());
    }

    @Test
    public void testFirstBadVersion2() {
        solution.setBadVersion(5);
        assertEquals(5, solution.firstBadVersion(5));
        System.out.println("calls : " + solution.getCalls());
    }
    @Test
    public void testFirstBadVersion3() {
        solution.setBadVersion(55);
        assertEquals(55, solution.firstBadVersion(500));
        System.out.println("calls : " + solution.getCalls());
    }
    @Test
    public void testFirstBadVersion4() {
        solution.setBadVersion(1);
        assertEquals(1, solution.firstBadVersion(2));
        System.out.println("calls : " + solution.getCalls());
    }
    @Test
    public void testFirstBadVersion5() {
        solution.setBadVersion(1);
        assertEquals(1, solution.firstBadVersion(3));
        System.out.println("calls : " + solution.getCalls());
    }
}