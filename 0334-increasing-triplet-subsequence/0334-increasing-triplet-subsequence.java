class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= small) {
                small = n;
            } else if (n <= big) {
                big = n;
            } else if (n >= big && n >= small) {
                System.out.println(small);
                System.out.println(big);
                System.out.println(n);
                return true;
            }
        }
        return false;
    }
}