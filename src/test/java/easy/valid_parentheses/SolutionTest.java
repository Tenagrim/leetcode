package easy.valid_parentheses;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void isValid() {
        assertTrue(solution.isValid("()"));
        assertFalse(solution.isValid("())"));
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid("((("));
        assertFalse(solution.isValid(")"));
        assertFalse(solution.isValid("))"));
        assertTrue(solution.isValid("[()]"));
        assertTrue(solution.isValid("({[](())[]})"));
        assertFalse(solution.isValid("({[]((())[)]})"));
    }
}