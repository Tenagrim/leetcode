package easy.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final Map<Character, Integer> VALUES_MAPPING ;
    static {
        VALUES_MAPPING = new HashMap<>();
        VALUES_MAPPING.put('I', 1);
        VALUES_MAPPING.put('V', 5);
        VALUES_MAPPING.put('X', 10);
        VALUES_MAPPING.put('L', 50);
        VALUES_MAPPING.put('C', 100);
        VALUES_MAPPING.put('D', 500);
        VALUES_MAPPING.put('M', 1000);
    }
    public int romanToInt(String s) {
        if (s.length() == 1)
            return VALUES_MAPPING.get(s.charAt(0));
        char[] chArr = s.toCharArray();
        int res = 0, cVal, nVal = VALUES_MAPPING.get(chArr[0]);
        for (int i = 1; i < s.length(); i++) {
            cVal = nVal;
            nVal = VALUES_MAPPING.get(chArr[i]);
            res += (cVal >= nVal) ? cVal : -cVal;
        }
        res += nVal;
        return res;
    }
}
