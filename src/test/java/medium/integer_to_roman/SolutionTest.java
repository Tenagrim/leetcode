package medium.integer_to_roman;


import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void testIntToRoman() {
        Assert.assertEquals("III", solution.intToRoman(3));
        Assert.assertEquals("LVIII", solution.intToRoman(58));
    }
    @Test
    public void secondTest(){
        Assert.assertEquals("IV", solution.intToRoman(4));
    }
    @Test
    public void thirdTest(){
        Assert.assertEquals("MCMXCIV", solution.intToRoman(1994));
    }
}