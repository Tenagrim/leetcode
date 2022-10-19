package medium.top_k_frequent_elements;

import java.util.*;


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> rates = new HashMap<>();
        for (int n : nums)
            rates.merge(n, 1, Integer::sum);

        return  rates.entrySet().stream()
                .sorted((el1,el2)->el2.getValue() - el1.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
