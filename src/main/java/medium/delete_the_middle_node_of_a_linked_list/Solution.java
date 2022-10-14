package medium.delete_the_middle_node_of_a_linked_list;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null)
            return null;
        int len = length(head);
        int position = len / 2;
        return deleteAt(head, position, len);
    }
    private int length(ListNode head){
        int len = 0;
        while (head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
    private ListNode deleteAt(ListNode head, int index, int len){
        ListNode p, p1 = head;
        if (index == 0){
            return head.next;
        }
        else{
            for (int i = 0; i < index-1; i++)
                p1 = p1.next;
            p = p1.next;
            p1.next = (index == len -1) ? null: p1.next.next;
            p = null;
        }
        return head;
    }
}
