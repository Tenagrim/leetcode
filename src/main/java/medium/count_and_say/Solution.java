package medium.count_and_say;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        ArrayList<Integer> prev = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        prev.add(1);
        prev.add(1);
        for (int i = 0; i < n -2; i++) {
            cur.clear();
            Iterator<Integer> it = prev.iterator();
            Integer prevNum = it.next(), curNum;
            int count = 1;
            /// count repeated nums
            while (it.hasNext()){
                curNum = it.next();
                if(prevNum.equals(curNum))
                    count++;
                else {
                    cur.add(count);
                    cur.add(prevNum);
                    count = 1;
                }
                prevNum = curNum;
            }
            cur.add(count);
            cur.add(prevNum);

            /// swap
            ArrayList<Integer> tmp = prev;
            prev = cur;
            cur = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(Integer it : prev)
            sb.append((char)('0' + it));
        return sb.toString();

    }
}
