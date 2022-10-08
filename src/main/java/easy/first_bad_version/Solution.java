package easy.first_bad_version;


public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1)
            return 1;
        int left = 0, right = n, mid;
        do{
            mid = left + (right - left) / 2;
            if (isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }while (right > left);
        return right;
    }
}