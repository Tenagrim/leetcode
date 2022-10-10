package medium.break_a_palindrome;

class Solution {
    public String breakPalindrome(String palindrome) {
        char[] chars = palindrome.toCharArray();
        int len = chars.length;
        boolean f = false;
        char c;
        for (int i = 0;  !f && i < len / 2; i++) {
            c = chars[i];
            if (c > 'a'){
                f= true;
                chars[i] = 'a';
            }
        }
        for (int i = len - 1;  !f && len != 1 && i >= len / 2; i--) {
            c = chars[i];
            if (c < 'z'){
                f = true;
                chars[i] = (char)( c + 1);
            }
        }

        return f? String.valueOf(chars) : "";
    }
}
