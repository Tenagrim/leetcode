package hard.string_compression_ii;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void getLengthOfOptimalCompression() {
        assertEquals(4, solution.getLengthOfOptimalCompression("aaabcccd", 2));
    }
    @Test
    public void getLengthOfOptimalCompression2() {
        assertEquals(2, solution.getLengthOfOptimalCompression("aabbaa", 2));
    }
    @Test
    public void getLengthOfOptimalCompression2_1() {
        assertEquals(2, solution.getLengthOfOptimalCompression("aabbaabbaa", 4));
    }
    @Test
    public void getLengthOfOptimalCompression3() {
        assertEquals(3, solution.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));
    }
    @Test
    public void getLengthOfOptimalCompression4() {
        assertEquals(2, solution.getLengthOfOptimalCompression("aabbb", 3));
    }
    @Test
    public void getLengthOfOptimalCompression5() {
        assertEquals(3, solution.getLengthOfOptimalCompression("abbbbbbbbbba", 2));
    }
    @Test
    public void getLengthOfOptimalCompression6() {
        assertEquals(3, solution.getLengthOfOptimalCompression("bbabbbabbbbcbb", 4));
    }
    @Test
    public void getLengthOfOptimalCompression7() {
        assertEquals(4, solution.getLengthOfOptimalCompression("llllllllllttttttttt", 1));
    }

    @Test
    public void countResult() {
        assertEquals(2,solution.countResult(List.of(new Solution.Pair('a', 3) ,new Solution.Pair('a', 3),new Solution.Pair('a', 3))));
    }
    @Test
    public void countResult2() {
        assertEquals(4,solution.countResult(List.of(new Solution.Pair('b', 3) ,new Solution.Pair('a', 3),new Solution.Pair('a', 3))));
    }
    @Test
    public void countResult3() {
        assertEquals(4,solution.countResult(List.of(new Solution.Pair('a', 3) ,new Solution.Pair('a', 3),new Solution.Pair('b', 3))));
    }
    @Test
    public void countResult4() {
        assertEquals(2,solution.countResult(List.of(new Solution.Pair('a', 9))));
        assertEquals(3,solution.countResult(List.of(new Solution.Pair('a', 15))));
    }
    @Test
    public void countResult5() {
        assertEquals(2,solution.countResult(List.of(new Solution.Pair('a', 3) ,new Solution.Pair('b', 3, true),new Solution.Pair('a', 3))));
    }
    @Test
    public void countResult6() {
        assertEquals(5,solution.countResult(List.of(new Solution.Pair('a', 3) ,new Solution.Pair('b', 1),new Solution.Pair('a', 3))));
    }
    @Test
    public void countResult7() {
        assertEquals(2,solution.countResult(List.of(new Solution.Pair('a', 1, true) ,new Solution.Pair('b', 8),new Solution.Pair('d', 1, true))));
    }
    @Test
    public void countResult7_1() {
        assertEquals(4,solution.countResult(List.of(new Solution.Pair('a', 2, false) ,new Solution.Pair('b', 8),new Solution.Pair('d', 1, true))));
    }
    @Test
    public void countResult8() {
        assertEquals(2,solution.countResult(List.of(new Solution.Pair('a', 3, true) ,new Solution.Pair('b', 8))));
    }
    @Test
    public void countResult9() {
        assertEquals(4, solution.countResult(List.of(new Solution.Pair('a', 3, false) ,new Solution.Pair('b', 8, false))));
    }
    @Test
    public void countResult10() {
        assertEquals(3, solution.countResult(List.of(new Solution.Pair('b', 2, false) ,new Solution.Pair('a', 1, true),new Solution.Pair('b', 3, false),new Solution.Pair('a', 1, true),new Solution.Pair('b', 3, false),new Solution.Pair('c', 1, true),new Solution.Pair('b', 2, false))));
    }
}