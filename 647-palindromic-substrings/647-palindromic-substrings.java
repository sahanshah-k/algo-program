class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            count += check(i, i, s);
            count += check(i, i + 1, s);
        }    
        return count;
    }
    
    int check(int i, int j, String s) {
        int l = i, r = j;
        int count = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count ++;
            l --;
            r ++;
        }
        return count;
    }
}