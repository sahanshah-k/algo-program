class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        String[][] out = new String[text2.length() + 1][text1.length() + 1];
        
        for (int i = 0; i < out.length; i ++) {
            for (int j = 0; j < out[0].length; j ++) {
                out[i][j] = "";
            }
        }
        
        for (int i = 1; i < out.length; i ++) {
            for (int j = 1; j < out[0].length; j ++) {
                if (text2.charAt(i - 1) != text1.charAt(j - 1)) {
                    out[i][j] = out[i-1][j].length() > out[i][j-1].length()
                        ? out[i - 1][j]
                        : out[i][j - 1];
                } else {
                    out[i][j] = out[i - 1][j - 1] + text2.charAt(i - 1);
                }
            }
        }
        return out[text2.length()][text1.length()].length();
    }
}