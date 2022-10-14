package medium.reverse_linked_list_ii;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();


    @Test
    public void reverseBetween() {
        ListNode head = asList(new int[]{1,2,3,4,5});
        head = solution.reverseBetween(head, 2, 4);
        assertArrayEquals(new int[]{1,4,3,2,5}, toArray(head));
    }
    @Test
    public void reverseBetween3() {
        ListNode head = asList(new int[]{1,2,3,4,5});
        head = solution.reverseBetween(head, 3, 4);
        assertArrayEquals(new int[]{1,2,4,3,5}, toArray(head));
    }
    @Test
    public void reverseBetween2() {
        ListNode head = asList(new int[]{1,2,3,4,5});
        head = solution.reverseBetween(head, 1, 5);
        assertArrayEquals(new int[]{5,4,3,2,1}, toArray(head));
    }
    @Test
    public void reverseBetwee4() {
        ListNode head = asList(new int[]{3,5});
        head = solution.reverseBetween(head, 1, 2);
        assertArrayEquals(new int[]{5,3}, toArray(head));
    }
    @Test
    public void reverseBetwee5() {
        ListNode head = asList(new int[]{3,5});
        head = solution.reverseBetween(head, 1, 1);
        assertArrayEquals(new int[]{3,5}, toArray(head));
    }
    @Test
    public void reverseBetwee6() {
        ListNode head = asList(new int[]{1,2,3});
        head = solution.reverseBetween(head, 1, 2);
        assertArrayEquals(new int[]{2,1,3}, toArray(head));
    }
    @Test
    public void reverseBetwee7() {
        ListNode head = asList(new int[]{1,2,3});
        head = solution.reverseBetween(head, 2, 3);
        assertArrayEquals(new int[]{1,3,2}, toArray(head));
    }
    @Test
    public void reverseBetwee8() {
        ListNode head = asList(new int[]{1,2,3,4});
        head = solution.reverseBetween(head, 2, 4);
        assertArrayEquals(new int[]{1,4,3,2}, toArray(head));
    }


    private ListNode asList(int[] content) {
        ListNode head = new ListNode(content[0]);
        ListNode p = head;
        for (int i = 1; i < content.length; i++) {
            p.next = new ListNode(content[i]);
            p = p.next;
        }
        return head;
    }

    private int[] toArray(ListNode head) {
        int len = getListSize(head);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }

    private int getListSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }


}