package medium.find_the_duplicate_number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            tortoise = nums[tortoise];
            hare = nums[hare];
            hare = nums[hare];
            if (tortoise == hare)
                break;
        }

        int p1 = nums[0];
        int p2 = hare;
        while(p1 != p2){
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
}
