package medium.reverse_linked_list_ii;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left >= right)
            return head;
        ListNode leftNode, preLeftNode = head;
        int p_left = left;
        if (left == 1) {
            leftNode = head;
            preLeftNode = null;
        } else {
            for (int i = 0; i < left - 2; i++)
                preLeftNode = preLeftNode.next;
            leftNode = preLeftNode.next;
        }
        ListNode mid = leftNode.next, front = mid.next;
        if (leftNode.next.next == null) {
            leftNode.next.next = leftNode;
            if (preLeftNode != null)
                preLeftNode.next = leftNode.next;
            leftNode.next = null;
            return left == 1 ? mid : head;
        }
        leftNode.next = null;
        ListNode rightNode = null;
        while (left < right && front != null) {
            rightNode = mid;
            mid.next = leftNode;
            leftNode = mid;
            mid = front;
            front = front.next;
            left++;
        }
        if (left < right && p_left == 1) { /// both elements reversed
            mid.next = leftNode;
            return mid;
        } else if (left < right) { /// last element reversed
            mid.next = leftNode;
            preLeftNode.next = mid;
            return head;
        }
        else if (p_left == 1) { // first element reversed
            head.next = mid;
            return leftNode;
        } else {
            preLeftNode.next.next = mid;
            preLeftNode.next = rightNode;
            return head;
        }
    }
}
