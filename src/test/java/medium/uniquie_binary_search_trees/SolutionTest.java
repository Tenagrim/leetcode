package medium.uniquie_binary_search_trees;

import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void numTrees() {
        Assert.assertEquals(1, solution.numTrees(1));
        Assert.assertEquals(2, solution.numTrees(2));
        Assert.assertEquals(5, solution.numTrees(3));
        Assert.assertEquals(14, solution.numTrees(4));
        Assert.assertEquals(16796, solution.numTrees(10));
        Assert.assertEquals(477638700, solution.numTrees(18));
    }
}