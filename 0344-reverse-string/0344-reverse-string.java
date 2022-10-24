class Solution {
    // public void reverseString(char[] s) {
    //     for (int i = 0, j = s.length - 1; i < s.length / 2; i ++, j --) {
    //         char t = s[i];
    //         s[i] = s[j];
    //         s[j] = t;
    //     }
    // }
    
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }    
    
    private void helper(char[] s, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(s, l, r);
        helper(s, l + 1, r - 1);
    }
    
    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;        
    }
}