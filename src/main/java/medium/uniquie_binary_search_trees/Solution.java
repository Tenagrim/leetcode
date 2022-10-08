package medium.uniquie_binary_search_trees;

public class Solution {
    public int numTrees(int n) {
        int count = 0;
        if (n == 1 || n == 0) return 1;
        for (int i = 0; i < n; i++)
            count += numTrees(n-i-1) * numTrees(i);
        return count;
    }
}
