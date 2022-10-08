package medium.uniquie_binary_search_trees_ii;

import org.junit.Test;


import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void generateTrees() {
        List<TreeNode> res = solution.generateTrees(3);
        assertEquals(5, res.size());
    }

    @Test
    public void generateTrees_2() {
        List<TreeNode> res = solution.generateTrees(1);
        assertEquals(1, res.size());
    }

}