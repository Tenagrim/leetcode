package medium.reorder_list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();


    @Test
    public void reorderList() {

        ListNode head = asList(new int[]{1,2,3,4});
        solution.reorderList(head);
        assertArrayEquals(new  int[]{1,4,2,3}, toArray(head));
    }
    @Test
    public void reorderList2() {

        ListNode head = asList(new int[]{1,2,3,4,5});
        solution.reorderList(head);
        assertArrayEquals(new  int[]{1,5,2,4,3}, toArray(head));
    }

    @Test
    public void reverseList(){
        ListNode head = asList(new int[]{1,2,3,4});
        ListNode rev = solution.reverse(head);
        assertArrayEquals(new  int[]{4,3,2,1}, toArray(rev));
    }
    @Test
    public void reverseList2(){
        ListNode head = asList(new int[]{1,2,3,4,5});
        ListNode rev = solution.reverse(head);
        assertArrayEquals(new  int[]{5,4,3,2,1}, toArray(rev));
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