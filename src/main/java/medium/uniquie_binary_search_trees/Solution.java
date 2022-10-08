package medium.uniquie_binary_search_trees;

public class Solution {
    private int numTreesC(int [] cache, int n) {
        int count = 0;
        if (n == 1 || n == 0) return 1;
        if (cache[n-1] != 0) return cache[n-1];
        for (int i = 0; i < n; i++)
            count += numTreesC(cache,n-i-1) * numTreesC(cache, i);
        return count;
    }

    public int numTrees(int n){
        int[] cache = new int[n];
        for (int i = 0; i < n; i++)
            cache[i] = numTreesC(cache,i+1);
        return cache[n-1];
    }

}
