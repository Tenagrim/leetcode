package medium.rotate_list;


import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void rotateRight() {
        assertArrayEquals(new int[]{3,1,2}, toArray(solution.rotateRight(asList(new int[]{1,2,3}),1)));
    }


    private ListNode asList(int[] content){
        ListNode head = new ListNode(content[0]);
        ListNode p = head;
        for (int i = 1; i < content.length; i++) {
            p.next = new ListNode(content[i]);
            p = p.next;
        }
        return head;
    }

    private int[] toArray(ListNode head){
        int len = getListSize(head);
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }

    private int getListSize(ListNode head){
        int count = 0;
        while (head != null){
            count ++;
            head = head.next;
        }
        return count;
    }

}