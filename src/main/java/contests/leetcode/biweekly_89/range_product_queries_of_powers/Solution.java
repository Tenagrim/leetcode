package contests.leetcode.biweekly_89.range_product_queries_of_powers;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int [] answers = new int[queries.length];
        int len = queries.length;
        List<Long> powers = new LinkedList<>();
        for (long i = 0; i < 32L; i++) {
            long tmp = n &( 1 << i );

            if (tmp != 0)
                powers.add(tmp);
        }


        for (int i = 0; i < len; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            long tmp = 1;
            for (int j = start; j <=end; j++) {
                tmp = tmp * powers.get(j) % 1000000007;
            }

            answers[i] =(int) tmp;
        }
        return answers;
    }
}
