class Solution {
    public String longestPalindrome(String s) {
        int[] sol = new int[] {Integer.MIN_VALUE, 0, 0};
        for (int i = 0; i < s.length(); i ++) {
            for (int j = i + 1; j < s.length(); j ++) {
                if ((j - i + 1) > sol[0] && verify(s, i, j)) {
                    sol[0] = j - i + 1;
                    sol[1] = i;
                    sol[2] = j;
                } 
            }
        }
        return s.substring(sol[1], sol[2] + 1);
    }
    
    private boolean verify(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}