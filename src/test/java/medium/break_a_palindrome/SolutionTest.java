package medium.break_a_palindrome;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();
    @Test
    public void breakPalindrome() {
        assertEquals("aaccba", solution.breakPalindrome("abccba"));
        assertEquals("", solution.breakPalindrome("a"));
    }
    @Test
    public void breakPalindrome2() {
        assertEquals("ab", solution.breakPalindrome("aa"));
        assertEquals("aaaaaaaaab", solution.breakPalindrome("aaaaaaaaaa"));
    }
    @Test
    public void breakPalindrome3() {
        assertEquals("azzz", solution.breakPalindrome("zzzz"));
        assertEquals("aazzzza", solution.breakPalindrome("azzzzza"));
    }
}