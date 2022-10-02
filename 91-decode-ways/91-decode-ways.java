class Solution {
    
    public int numDecodings1(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }
    
    private int helper(String s, int pos, int[] dp) {
        
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
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        
        for (int i = s.length() - 2; i >= 0; i --) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                int t = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (t <= 26) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                } else {
                    dp[i] = dp[i + 1];
                }
            }
        }
        return dp[0];
    }
    
}