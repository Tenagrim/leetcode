package medium.delete_the_middle_node_of_a_linked_list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();
    @Test
    public void deleteMiddle() {
        assert listsAreEqual(asList(new int[]{1,3,4,1,2,6}), solution.deleteMiddle(asList(new int[]{1,3,4,7,1,2,6})));
        assert listsAreEqual(asList(new int[]{1,2,4}), solution.deleteMiddle(asList(new int[]{1,2,3,4})));
        assert listsAreEqual(asList(new int[]{2}), solution.deleteMiddle(asList(new int[]{2, 1})));
    }

    private boolean listsAreEqual(ListNode a, ListNode b){
        while (a != null){
            if (b == null || a.val != b.val)
                return false;
            a = a.next;
            b = b.next;
        }
        return true;
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
}