package medium.zigzag_conversion;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private  final Solution solution = new Solution();
    @Test
    public void convert() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4));
        assertEquals("A", solution.convert("A", 1));
    }
    @Test
    public void convert2() {
        assertEquals("ABCED", solution.convert("ABCDE", 4));
        assertEquals("ABCDE", solution.convert("ABCDE", 10));
    }
}