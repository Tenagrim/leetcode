package easy.roman_to_integer;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    Solution solution = new Solution();
    public void testRomanToInt() {
        Assert.assertEquals(3, solution.romanToInt("III"));
        Assert.assertEquals(58, solution.romanToInt("LVIII"));
        Assert.assertEquals(1994, solution.romanToInt("MCMXCIV"));
    }
}