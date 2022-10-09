package easy.two_sum_iv_bst;


import java.util.Stack;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return iterative(root,k);
    }

    private boolean iterative(TreeNode root, int k){
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> r = new Stack<>();
        s.push(root);
        r.push(root);
        TreeNode normal = getNextInOrder(s, false);
        TreeNode reverse = getNextInOrder(r, true);
        do{
            if (normal == null || reverse == null)
                return false;
            int sum = normal.val + reverse.val;

            if(sum == k && normal != reverse)
                return true;
            else if (sum < k){
                normal = getNextInOrder(s,false);

            }else{
                reverse = getNextInOrder(r, true);
            }
        }while (normal != null && reverse != null && normal.val < reverse.val);
        return false;
    }
    private TreeNode getNextInOrder(Stack<TreeNode> s,  boolean reverse) {
        if (s.isEmpty())
            return null;
        TreeNode curr = s.pop();
        while (curr != null) {
            s.push(curr);
            curr = reverse ? curr.right : curr.left ;
        }
        if (s.isEmpty())
            return null;
        curr = s.pop();
        s.push(reverse ? curr.left : curr.right);
        return curr;
    }


    // DOES NOT WORK
    private boolean recursive(TreeNode normal, TreeNode reverse, int k) {
        if (normal == null || reverse == null)
            return false;
        boolean found = false;

        // normal inorder traversal
        if (normal.left != null)
            found |= recursive(normal.left, reverse, k);
        else if (normal.right != null)
            found |= recursive(normal.right, reverse, k);

        //reverse inorder traversal
        if (reverse.right != null)
            found |= recursive(normal, reverse.right, k);
        else if (reverse.left != null)
            found |= recursive(normal, reverse.left, k);

        int sum = normal.val + reverse.val;
        // System.out.println(normal.val + " " + reverse.val);

        if (found || (sum == k && reverse != normal))
            return true;
        if (normal.val < reverse.val)
            return false;
        else if (sum < k) {
            return recursive(normal.left, reverse, k) || recursive(normal.right, reverse, k);
        } else if (sum > k) {
            return recursive(normal, reverse.right, k) || recursive(normal, reverse.left, k);
        }
        return false;
    }
}
