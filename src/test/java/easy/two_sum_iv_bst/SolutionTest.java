package easy.two_sum_iv_bst;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void findTarget() {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        assertTrue(solution.findTarget(root, 9));
        assertFalse(solution.findTarget(root, 28));
    }

    @Test
    public void findTarget2() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        assertTrue(solution.findTarget(root, 4));
    }

    @Test
    public void findTarget3() {
        TreeNode root = new TreeNode(0, new TreeNode(-3, new TreeNode(-4), null), new TreeNode(2, new TreeNode(1), null));
        assertTrue(solution.findTarget(root, 1));
    }

    @Test
    public void findTarget4() {
        Integer[] nums = new Integer[]{2967, 1642, 3196, 1075, 2734, 3075, 3701, 301, 1499, 2607, 2809, 2982, 3152, 3350, 3753, 8, 338, 1439, 1586, 1683, null, 2749, 2843, null, null, null, null, 3258, 3429, 3734, 3987, null, 247, 328, 643, 1274, null, null, null, null, 1856, null, null, null, 2882, 3235, null, 3375, 3615, null, null, 3913, 5001, 51, null, null, null, 451, 898, 1146, 1403, 1801, 2282, null, null, null, null, null, null, 3474, null, 3849, null, 4723, 5036, null, 128, 362, 527, 686, 1026, 1085, null, 1338, null, 1723, 1836, 1999, 2342, null, 3526, 3771, null, 4201, 4901, null, 5416, null, 211, null, null, 468, 588, null, 766, 970, 1044, null, null, null, null, null, 1768, null, null, 1932, 2115, null, 2544, null, null, null, 3824, 4142, 4465, 4813, null, 5200, null, null, null, null, null, null, null, 736, 834, null, null, null, null, null, null, null, null, 2043, 2173, 2452, null, null, null, 4053, null, 4389, 4627, null, null, 5150, 5216, null, null, null, null, null, 2098, null, 2271, 2416, 2532, null, null, 4317, 4429, 4546, null, 5114, null, null, 5311, null, null, null, null, null, null, null, null, 4274, null, null, null, null, null, null, null, null, 5383};
        TreeNode root = fillTree(nums);

        assertTrue(solution.findTarget(root, 5894));
    }

    @Test
    public void findTarget9() {
        Integer[] nums = new Integer[]{2663, 960, 5111, 891, 2542, 3002, null, 173, 912, 1377, 2585, 2958, 4431, 143, 761, null, null, 1259, 1891, null, 2649, 2726, null, 4378, 4463, 129, null, 448, 865, 1246, 1318, 1669, 2506, null, null, null, 2812, 3837, null, null, 5041, 0, null, 392, 712, 805, null, 1234, null, null, null, 1575, 1821, 2323, null, null, 2904, 3353, 4327, 4940, null, null, 65, 261, null, 495, 736, null, null, 1089, null, 1513, 1658, 1799, null, 2225, 2398, null, null, 3248, 3587, 4271, null, 4706, 4969, null, null, null, 349, null, 601, null, null, 1053, 1156, 1440, null, 1620, null, 1785, null, 2215, 2255, 2378, null, 3092, 3268, 3478, 3714, 3999, 4313, 4616, 4764, 4951, null, 334, null, null, null, null, null, 1114, null, null, null, null, null, null, null, 2072, null, null, null, null, null, null, 3107, null, 3286, 3453, 3575, 3671, 3780, 3851, 4210, null, null, 4548, null, null, 4825, null, null, null, null, null, null, 1943, 2108, null, 3176, null, null, 3429, null, null, null, 3634, null, null, null, null, null, 4065, null, 4472, null, null, null, null, 1962, null, null, 3140, null, null, null, null, null, null, 4141, null, null, null, 2000};
        TreeNode root = fillTree(nums);

        assertTrue(solution.findTarget(root, 7614));
    }

    @Test
    public void findTarget10() {

        Integer[] nums = new Integer[]{-38, -43, 4, -45, null, -37, 16, -48, null, null, -35, 12, 36, null, null, null, 1, 6, 14, 30, 41, -25, 3, 5, 9, null, null, 17, null, 39, 42, -27, -11, null, null, null, null, null, null, null, 23, null, 40, null, 47, -33, -26, -18, -2, 20, 29, null, null, 46, 49, -34, -32, null, null, -24, -15, -8, 0, null, 21, null, null, 44, null, null, null, null, null, null, -28, null, -22, null, -13, -10, -7, null, null, null, null, null, null, -31, null, null, -19};
        TreeNode root = fillTree(nums);
        //System.out.println(treeToString(root));
        //order(root, root);

        assertTrue(solution.findTarget(root, -76));
    }

    @Test
    public void findTarget5() {
        Integer[] nums = new Integer[]{1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        TreeNode root = fillTree(nums);
        assertTrue(solution.findTarget(root, 1));
    }

    @Test
    public void findTarget6() {
        int i = 1;
        List<Integer[]> variants = new ArrayList<>();
        variants.add(new Integer[]{0, -3, 1, 4, 2});
        variants.add(new Integer[]{0, 4, 1, -3, 2});
        variants.add(new Integer[]{0, 4, -3, 1, 2});
        variants.add(new Integer[]{0, -3, 2, 4, 1});
        variants.add(new Integer[]{0, -3, 1, 2, 4});
        variants.add(new Integer[]{-3, 0, 1, 4, 2});
        variants.add(new Integer[]{-3, 0, 4, 1, 2});
        variants.add(new Integer[]{4, 0, -3, 1, 2});
        variants.add(new Integer[]{4, 1, -3, 0, 2});
        variants.add(new Integer[]{2, 1, -3, 0, 4});
        variants.add(new Integer[]{2, 0, -3, 1, 4});
        for (Integer[] nums : variants) {
            TreeNode root = fillTree(nums);
            assertTrue(solution.findTarget(root, 3));
            assertTrue(String.valueOf(i), solution.findTarget(root, -3));
            assertTrue(String.valueOf(i), solution.findTarget(root, -2));
            assertTrue(solution.findTarget(root, 1));
            assertTrue(solution.findTarget(root, -1));
            assertTrue(solution.findTarget(root, 2));
            assertTrue(solution.findTarget(root, 5));
            assertTrue(solution.findTarget(root, 4));
            assertTrue(solution.findTarget(root, 6));
            i++;
        }
    }

    @Test
    public void findTarget7() {
        Integer[] nums = new Integer[]{4, 1, -3, 0, 2};
        TreeNode root = fillTree(nums);

        //iterativeOrder(root);

        assertTrue(solution.findTarget(root,-2));
    }

    @Test
    public void findTarget8() {
        Integer[] nums = new Integer[]{24, 16, 32, 8};
        TreeNode root = fillTree(nums);
        assertTrue(solution.findTarget(root, 48));
    }

    private TreeNode fillTree(Integer[] nums) {
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            Integer n = nums[i];
            if (n != null)
                addNumber(root, n);
        }
        return root;
    }

    private void addNumber(TreeNode root, int number) {
        if (number >= root.val) {
            if (root.right == null)
                root.right = new TreeNode(number);
            else
                addNumber(root.right, number);
        } else {
            if (root.left == null)
                root.left = new TreeNode(number);
            else
                addNumber(root.left, number);
        }
    }

    private String treeToString(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        treeToStringRec(root, sb);
        return sb.toString();
    }

    private void treeToStringRec(TreeNode cur, StringBuilder sb) {
        sb.append(',');
        if (cur == null) {
            sb.append("null");
            return;
        }
        sb.append(cur.val);
        treeToStringRec(cur.left, sb);
        treeToStringRec(cur.right, sb);

    }

    private void order(TreeNode normal, TreeNode reverse) {

        if (normal == null || reverse == null) {
            System.out.println("FAIL");
            return;
        }

        // only normal order
        if (normal.left != null)
            order(normal.left, reverse);
        System.out.println(normal.val + " " + reverse.val);
        if (normal.right != null)
            order(normal.right, reverse);


//        // only reverse order
//        if (reverse.right != null)
//            order(normal, reverse.right);
//        System.out.println(normal.val + " " + reverse.val);
//        if (reverse.left != null) {
//            order(normal, reverse.left);
//        }


        // mixed order // IMPOSSIBLE
        if (normal.left != null) {
            // only reverse order
            if (reverse.right != null)
                order(normal.left, reverse.right);
            System.out.println(normal.val + " " + reverse.val);
            if (reverse.left != null)
                order(normal.left, reverse.left);
            //order(normal.left, reverse);
        }
        //System.out.println(normal.val + " " + reverse.val);
        if (normal.right != null) {
            // only reverse order
            if (reverse.right != null)
                order(normal.right, reverse.right);
            System.out.println(normal.val + " " + reverse.val);
            if (reverse.left != null)
                order(normal.right, reverse.left);

        }


    }

    private void iterativeOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> r = new Stack<>();
        s.push(root);
        r.push(root);
        TreeNode normal;
        TreeNode reverse;
        do{
            normal = getNextInOrder(s,false);
            reverse = getNextInOrder(r,true);
            if (normal != null && reverse != null )
             System.out.println(normal.val + " " + reverse.val);
            else break;

        }while (true);

    }

    private void iterativeBothOrder(TreeNode root, boolean reverse) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.empty()) {
            curr = s.pop();
            while (curr != null) {
                s.push(curr);
                curr = reverse ? curr.left : curr.right;
            }
            curr = s.pop();
            System.out.println(curr.val);
            s.push(reverse ? curr.right : curr.left);
        }
    }

    private TreeNode getNextInOrder(Stack<TreeNode> s,  boolean reverse) {
        if (s.isEmpty())
            return null;
        TreeNode curr = s.pop();
        while (curr != null) {
            s.push(curr);
            curr = reverse ? curr.left : curr.right;
        }
        if (s.isEmpty())
            return null;
        curr = s.pop();
        s.push(reverse ? curr.right : curr.left);
        return curr;
    }


}