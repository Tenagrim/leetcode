package medium.top_k_frequent_words;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> rates = new HashMap<>();
        for (String w : words) {
            Integer rate = rates.get(w);
            if (rate == null)
                rates.put(w, 1);
            else rates.put(w, rate + 1);
        }

        return rates.entrySet().stream()
                .sorted((el1,el2)->{return el2.getValue() - el1.getValue()==0 ? el1.getKey().compareTo(el2.getKey()) : el2.getValue() - el1.getValue();})
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
