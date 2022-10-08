package medium.uniquie_binary_search_trees_ii;


import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return getSubtrees(1, n);
    }

    private List<TreeNode> getSubtrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (end - start == 0)
            res.add(new TreeNode(start, null, null));
        else if (end - start > 0) {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubtrees = getSubtrees(start, i - 1);
                List<TreeNode> rightSubtrees = getSubtrees(i + 1, end);
                if (leftSubtrees.isEmpty())
                    for (TreeNode r : rightSubtrees)
                        res.add(new TreeNode(i, null, r));
                else if (rightSubtrees.isEmpty())
                    for (TreeNode l : leftSubtrees)
                        res.add(new TreeNode(i, l, null));
                else
                    for (TreeNode l : leftSubtrees)
                        for (TreeNode r : rightSubtrees)
                            res.add(new TreeNode(i, l, r));
            }
        }
        return res;
    }
}
