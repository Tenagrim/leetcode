package hard.minimum_difficulty_of_a_job_schedule;

import java.util.Arrays;

public class Solution {

    private int[][] variants;
    private int[] difficulties;
    private int n;

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if (d > n)
            return -1;
        variants = new int[d + 1][n];
        difficulties = jobDifficulty;
        for (int[] r : variants)
            Arrays.fill(r, -1);
        return recursive(d, 0);
    }

    private int recursive(int d, int idx) {
        if (d == 1) {
            int max = 0;
            while (idx < n)
                max = Math.max(max, difficulties[idx++]);
            return max;
        }
        if (variants[d][idx] != -1)
            return variants[d][idx];
        int lMax = 0;
        int res = Integer.MAX_VALUE;
        for (int i = idx; i < n - d + 1; i++) {
            lMax = Math.max(lMax, difficulties[i]);
            res = Math.min(res, lMax + recursive(d - 1, i + 1));
        }
        variants[d][idx] = res;
        return res;
    }
}
