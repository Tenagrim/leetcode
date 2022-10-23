package contests.leetcode.weekly_316.determine_if_two_events_have_conflict;

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {

        TimeRange t1 = new TimeRange(getTimestamp(event1[0]), getTimestamp(event1[1]));
        TimeRange t2 = new TimeRange(getTimestamp(event2[0]), getTimestamp(event2[1]));
       if (t1.start > t2.start){
           TimeRange tmp = t1;
           t1 = t2;
           t2 = tmp;
       }
        return t1.stop >= t2.start;
    }

    private class TimeRange{
        int start;
        int stop;

        public TimeRange(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }
    }

    private int getTimestamp(String event){
        String[]st = event.split(":");
        return Integer.parseInt(st[0]) * 60 + Integer.parseInt(st[1]);
    }
}
