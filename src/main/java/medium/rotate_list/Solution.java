package medium.rotate_list;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = listLen(head);
        ListNode tail = head, breakNode = head;
        k %=len;
        if (k == 0)
            return head;
        for (int i = 0; i < len-1; i++) {
            if(i == len - k - 1)
                breakNode = tail;
            tail = tail.next;
        }
        tail.next = head;
        head = breakNode.next;
        breakNode.next = null;
        return head;
    }

    private int listLen(ListNode head){
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
