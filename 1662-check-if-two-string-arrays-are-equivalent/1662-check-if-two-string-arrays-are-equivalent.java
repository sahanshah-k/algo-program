class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int s1 = 0, s2 = 0, c1 = 0, c2 = 0;
        while (s1 < word1.length && s2 < word2.length) {
            if (word1[s1].charAt(c1) != word2[s2].charAt(c2)) {
                return false;
            }
            c1 = c1 + 1;
            c2 = c2 + 1;
            if (c1 == word1[s1].length()) {
                c1 = 0;
                s1 ++;
            }
            if (c2 == word2[s2].length()) {
                c2 = 0;
                s2 ++;
            }
        }
        return s1 == word1.length && s2 == word2.length;        
    }
}