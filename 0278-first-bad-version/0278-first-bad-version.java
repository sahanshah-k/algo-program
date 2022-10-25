/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0, r = n;
        int m = 0;
        while (r - l > 1) {
            m =  l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }
}