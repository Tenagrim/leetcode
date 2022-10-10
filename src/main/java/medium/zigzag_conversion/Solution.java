package medium.zigzag_conversion;

class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        int period = (numRows + numRows - 2);
        if (period == 0)
            return s;
        int periods = len >= period ? len / period : 1;
        if (periods * period < len)
            periods += 1;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < periods; i++) {
                int tmp = i * period + j;
                if (tmp < len)
                    sb.append(s.charAt(tmp));
                if (j != 0 && j != numRows - 1) {
                    tmp = i * period + (numRows * 2 - j - 2);
                    if (tmp < len)
                        sb.append(s.charAt(tmp));
                }

            }
        }
        return sb.toString();
    }
}
