class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        return helper(0, s);
    }
    
    boolean helper(int i, String s) {
        if (i >= s.length() / 2) {
            return true;
        }
        if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            return false;
        }
        return helper(i + 1, s);
    }
}