package medium.reorder_list;

class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null)
            return;
        ListNode rev, p = head;
        int len = length(head);
        for (int i = 0; i < len/2 -1; i++)
            p = p.next;
        rev = p.next;
        p.next = null;
        // reverse list with even elements
        rev = reverse(rev);
        // zip two lists together
        zipLists(head,rev);
        System.out.println();
    }

    private int length(ListNode head){
        int len = 0;
        while (head!=null){
            head = head.next;
            len++;
        }
        return len;
    }

    public void reorderList2(ListNode head) {
        if (head.next == null || head.next.next == null)
            return;
        ListNode p = head.next.next, front;
        ListNode rev = head.next;
        ListNode p_rev = rev;
        head.next = p;
        // let odd elements remain in head, even elements will move to rev
        while (p != null) {
            p_rev.next = p.next;
            p_rev = p_rev.next;
            if (p.next != null) {
                p.next = p.next.next;
            }
            if (p_rev != null)
                p_rev.next = null;
            p = p.next;
        }
        // reverse list with even elements
        rev = reverse(rev);
        // zip two lists together
        zipLists(head,rev);
        System.out.println();
    }

    private void zipLists(ListNode a, ListNode b){
        ListNode tail = b;
        ListNode front_a = a.next, front_b = b.next;
        while (a != null){
            a.next = b;
            b.next = front_a;
           tail = b;
            a=front_a;
            b=front_b;
            if (front_a != null)
                front_a = front_a.next;
            if (front_b != null)
                front_b = front_b.next;
        }
        if (b != null)
            tail.next = b;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode mid = head.next, front = head.next.next;
        if (head.next.next == null){
            head.next.next = head;
            head.next = null;
            return mid;
        }
        head.next = null;
        while (front != null){
            mid.next = head;
            head = mid;
            mid = front;
            front = front.next;
        }
        mid.next = head;
        return mid;
    }
}
