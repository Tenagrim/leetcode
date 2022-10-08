package easy.valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    private static final Map<Character,Character> MAPPING;
    static {
        MAPPING = new HashMap<>();
        MAPPING.put(')','(');
        MAPPING.put(']','[');
        MAPPING.put('}','{');
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Character c;
        boolean f = true;
        for (int i = 0; f && i < s.length(); i++) {
            c = s.charAt(i);
            if(MAPPING.containsValue(c))
                st.push(c);
            else if ((c = MAPPING.get(c)) == null || st.isEmpty() || st.pop() != c)
                f = false;
        }
        return st.isEmpty() && f;
    }
}
