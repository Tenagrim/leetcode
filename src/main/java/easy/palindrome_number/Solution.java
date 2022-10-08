package easy.palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        return recursive(x, x) != -1;
    }
    private int recursive(int num, int copy){
        if (copy == -1)
            return -1;
        if (num == 0)
            return copy;
        copy = recursive(num / 10 , copy);
        //System.out.println(num + "  " + copy);
        return (num % 10 == copy % 10) ? copy / 10 : -1;
    }
}
