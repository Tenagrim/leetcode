package hard.string_compression_ii;

import java.util.*;

public class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        List<Pair> rates = getRates(s);
        //  rates.sort(Comparator.comparing(Pair::getCount));
        if (rates.size() == 1) {
            int count = rates.get(0).count;
            count -= k;
            if (count <= 0)
                return 0;
            return count == 1 ? 1 : digitsCount(count) + 1;
        }
        // does not consider subtraction k if k less than minimal block
        return recursive(rates, k);
    }

    private int recursive(List<Pair> rates, int k) {
        if (k < 0)
            return Integer.MAX_VALUE;
        else if (k == 0)
            return countResult(rates);
        int res = Integer.MAX_VALUE;
        for (Pair rate : rates) {
            if (!rate.excluded) {
                rate.excluded = true;
                res = Math.min(res, recursive(rates, k - rate.count));
                rate.excluded = false;
                res = Math.min(res, countResult(rates));
            }
        }
        return res;
    }

    int countResult(List<Pair> rates) {
        int res = 0;
        Iterator<Pair> it = rates.iterator();
        Pair prev = it.next(), cur = prev;
        while (prev.excluded)
            prev = it.next();
        int prev_sum = prev.count;
        Pair lastNotExcluded = prev;
        boolean f = false;
        while (it.hasNext()) {
            cur = it.next();
            if (!cur.excluded) {
                if (prev.c == cur.c) {
                    prev_sum += prev.count;
                } else {
                    res += prev_sum == 1 ? 1 : digitsCount(prev_sum) + 1;
                    prev_sum = cur.count;
                    f = true;
                    lastNotExcluded = cur;
                }
                prev = cur;
            }
        }
        if (lastNotExcluded == cur || !f)
            res += prev_sum == 1 ? 1 : digitsCount(prev_sum) + 1;
        else
            res += lastNotExcluded.count == 1 ? 1 : digitsCount(lastNotExcluded.count) + 1;
        return res;
    }

    private int digitsCount(int n) {
        if (n < 10)
            return 1;
        else if (n < 100)
            return 2;
        else if (n < 1000)
            return 3;
        else if (n < 10000)
            return 4;
        else if (n < 100000)
            return 5;
        else if (n < 1000000)
            return 6;
        else if (n < 10000000)
            return 7;
        else if (n < 100000000)
            return 8;
        else if (n < 1000000000)
            return 9;
        return -1;
    }

    private List<Pair> getRates(String s) {
        int len = s.length();
        int cnt = 1;
        char prev = s.charAt(0), c = prev;
        List<Pair> rates = new LinkedList<>();
        for (int i = 1; i < len; i++) {
            c = s.charAt(i);
            if (c != prev) {
                rates.add(new Pair(prev, cnt));
                prev = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        rates.add(new Pair(c, cnt));

        return rates;
    }

    static final class Pair {
        public Pair(char c, int count, boolean excluded) {
            this.c = c;
            this.count = count;
            this.excluded = excluded;
        }

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        char c;
        int count;
        boolean excluded = false;
    }


    private int getTripleResult(List<Pair> rates, int k) {
        Iterator<Pair> it = rates.iterator();
        int toDel = 0, res = 0;
        Pair first = it.next();
        Pair second = it.next();
        Pair third = it.next();
        while (it.hasNext()) {

            if (first.c == third.c) {

            } else {

            }

            first = second;
            second = third;
            third = it.next();
        }
        return 0;
    }

    private int getResult(List<Pair> rates, int k) {
        int toDel = 0, res = 0;
        Iterator<Pair> it = rates.iterator();
        Pair prev = it.next(), cur = prev;
        while (it.hasNext()) {
            cur = it.next();
            if (toDel < k && cur.count + toDel <= k) {
                toDel += cur.count;
            } else {
                res += cur.count == 1 ? 1 : digitsCount(cur.count) + 1;
            }
            prev = cur;
        }

        return res;
    }

    private class Solution2{
        private int[][] variants;
        private char[] bytes;
        private int n;

        public int getLengthOfOptimalCompression(String s, int k) {
            this.bytes = s.toCharArray();
            this.n = s.length();
            this.variants = new int[n][k + 1];
            for (int[] row : variants)
                Arrays.fill(row, -1);
            return recursive(0, k);
        }

        private int recursive(int i, int k) {
            if (k < 0) return n;
            if (i + k >= n) return 0;
            int res = variants[i][k];
            if (res != -1) return res;
            res = recursive(i + 1, k - 1);
            int len = 0;
            int same = 0;
            int diff = 0;
            for (int j = i; j < n && diff <= k; j++) {
                if (bytes[j] == bytes[i]) {
                    same++;
                    if (same <= 2 || same == 10 || same == 100) len++;
                } else {
                    diff++;
                }
                res = Math.min(res, len + recursive(j + 1, k - diff));
            }
            variants[i][k] = res;
            return res;
        }
    }
}
