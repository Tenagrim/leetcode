package easy.palindrome_number;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void isPalindrome() {
        Assert.assertTrue(solution.isPalindrome(122232221));
        Assert.assertTrue(solution.isPalindrome(1));
        Assert.assertFalse(solution.isPalindrome(10));
        Assert.assertFalse(solution.isPalindrome(1234));
        Assert.assertFalse(solution.isPalindrome(1222322221));
        Assert.assertTrue(solution.isPalindrome(0));
        Assert.assertFalse(solution.isPalindrome(-121));
    }

    @Test
    public void negative(){
        Assert.assertTrue(solution.isPalindrome(-121));
    }
}