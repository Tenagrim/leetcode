package contests.leetcode.biweekly_89.range_product_queries_of_powers;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void productQueries() {
        solution.productQueries(15, new int[][]{new int[]{0,1},new int[]{2,2},new int[]{0,3}});
    }
    @Test
    public void productQueries2() {
       assertEquals(621940455, solution.productQueries(806335498, new int[][]{new int[]{1,8}})[0]);
    }
}