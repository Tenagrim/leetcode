package medium.rotate_array;

class Solution {
    // O(2n) time
    // O(1) space
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k < 0)
            k = nums.length - k;
        int border = nums.length -k;
        reverse(nums, 0, border -1);
        reverse(nums, border, nums.length -1);
        reverse(nums, 0, nums.length -1);
    }

    private void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
