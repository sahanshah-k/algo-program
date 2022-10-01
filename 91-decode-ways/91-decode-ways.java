class Solution {
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    
    private int helper(String s, int pos, int[] dp) {
        System.out.println(Arrays.toString(dp));
        
        if (dp[pos] != -1) {
            return dp[pos];
        }
        
        if (pos == s.length()) {
            return 1;
        } 
        
        if (s.charAt(pos) == '0') {
            return 0;
        }
                
        int doubleDigit = 0;
        int singleDigit = 0;
                
        if (pos + 2 <= s.length() && Integer.parseInt(s.substring(pos, pos + 2)) <= 26) {
            doubleDigit = helper(s, pos + 2, dp);
            singleDigit = helper(s, pos + 1, dp);
            dp[pos] = doubleDigit + singleDigit;
        } else {
            dp[pos] = helper(s, pos + 1, dp);
        }            
        return dp[pos];
    }
    
}