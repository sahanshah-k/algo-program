class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int[] alpha = new int[26];
        int count = 0;
        for (int i = 0; i < sentence.length(); i ++) {
            int v = sentence.charAt(i) - 'a';
            if (alpha[v] != 1) {
                count ++;
                alpha[v] = 1;
            }
        }
        
        return count == 26;
        
    }
}