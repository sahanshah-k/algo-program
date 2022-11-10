class Solution {
    public String removeStars(String s) {
        int j = 0;
        char[] out = new char[s.length()];
        for (int i = 0; i < s.length(); i ++, j ++) {
            out[j] = s.charAt(i);
            if (j > 0 && out[j] == '*' && out[j - 1] != '*') {
                j -= 2;
            }
        }
        return new String(out, 0, j);
    }
}