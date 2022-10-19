package medium.top_k_frequent_words;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> rates = new HashMap<>();
        for (String w : words)
            rates.merge(w, 1, Integer::sum);

        return rates.entrySet().stream()
                .sorted((el1, el2) -> {
                    int diff = el2.getValue() - el1.getValue();
                    return diff == 0 ? el1.getKey().compareTo(el2.getKey()) : diff;
                })
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
