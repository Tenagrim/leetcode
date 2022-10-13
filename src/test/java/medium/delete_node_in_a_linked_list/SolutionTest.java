package medium.delete_node_in_a_linked_list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void deleteNode() {
        ListNode toDel = new ListNode(5, new ListNode(1, new ListNode(9,null)));
        ListNode head = new ListNode(4, toDel);
        solution.deleteNode(toDel);
        assertEquals(3,getListSize(head));


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