class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int p1 = 0, p2 = 0;
        while (p2 < t.length()) {
            char c1 = s.charAt(p1);
            char c2 = t.charAt(p2);
            if (c1 == c2) {
                p1 ++;
            }
            p2 ++;
            if (p1 == s.length()) {
                return true;
            }
        }
        return false;
    }
}