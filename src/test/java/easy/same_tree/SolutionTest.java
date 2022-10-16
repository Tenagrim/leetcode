package easy.same_tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void isSameTree() {
        TreeNode root = new TreeNode(1,new TreeNode(1), new TreeNode(2));
        TreeNode root2 = new TreeNode(1,new TreeNode(2), new TreeNode(1));
        assertFalse(solution.isSameTree(root, root2));
    }
}