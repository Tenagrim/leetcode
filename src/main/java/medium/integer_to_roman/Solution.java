package medium.integer_to_roman;

import java.util.*;

public class Solution {
    private static final Map<Integer, Character> VALUES_MAPPING;

    static {
        VALUES_MAPPING = new LinkedHashMap<>();
        VALUES_MAPPING.put(1000, 'M');
        VALUES_MAPPING.put(500, 'D');
        VALUES_MAPPING.put(100, 'C');
        VALUES_MAPPING.put(50, 'L');
        VALUES_MAPPING.put(10, 'X');
        VALUES_MAPPING.put(5, 'V');
        VALUES_MAPPING.put(1, 'I');
    }

    public String intToRoman(int num) {
        for (Integer i : VALUES_MAPPING.keySet())
            if (num == i)
                return VALUES_MAPPING.get(i).toString();
        StringBuilder res = new StringBuilder();
        int keysLen = VALUES_MAPPING.size();
        Integer[] keys = VALUES_MAPPING.keySet().toArray(new Integer[keysLen]);
        for (int i = 0; i < keysLen; i++) {
            int out = keys[i];
            while (num - out >= 0){
                num -= out;
                res.append(VALUES_MAPPING.get(out));
            }
            for (int j = i+1; j < keysLen; j++) {
                int in = keys[j];
                int supSum = num - (out -in);
                if(i != keysLen-1 && supSum >= 0 && (num - keys[i+1] > supSum ) ){
                    num -= out - in;
                    res.append(VALUES_MAPPING.get(in));
                    res.append(VALUES_MAPPING.get(out));
                    break;
                }
            }

        }
        return res.toString();
    }
}
