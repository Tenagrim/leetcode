package contests.leetcode.biweekly_89.number_of_valid_clock_times;

public class Solution {
    public int countTime(String time) {
        int res = 1;
        if (time.charAt(0) == '?' && time.charAt(1) == '?' ){
            res *= 24;
        }else {
            if (time.charAt(0) == '?'){
                if(time.charAt(1) != '?' && (time.charAt(1) - '0') >= 4)
                    res *= 2;
                else res *= 3;
            }
            if (time.charAt(1) == '?'){
                if(time.charAt(0) == '?' || (time.charAt(0) - '0') < 2)
                    res *= 10;
                else if ((time.charAt(0) - '0') == 2)
                    res *= 4;
            }
        }

            if (time.charAt(3) == '?'){
                res *= 6;
            }
            if (time.charAt(4) == '?'){
                res *= 10;
            }

        return res;
    }
}
