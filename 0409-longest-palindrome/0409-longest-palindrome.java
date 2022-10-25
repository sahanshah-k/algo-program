class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray()) {
            count[c]++;
        }
        int out = 0;
        boolean oddAdded = false;
        for (int i: count) {
            if (i % 2 == 0) {
                out += i;
            } else if (i % 2 != 0 && !oddAdded) {
                out += i;
                oddAdded = true;
            } else if (i % 2 != 0) {
                out += i - 1;
            } 
        }
        return out;
    }
}