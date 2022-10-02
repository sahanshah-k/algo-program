class Solution {
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 1;
        return dfs(0, dp, s);
        
    }
    
    int dfs(int i, int[] dp, String s) {
        if (dp[i] != -1) {
            return dp[i];
        }
        
        if (i >= s.length() || s.charAt(i) == '0') {
            return 0;
        } 
        
        int res = dfs(i + 1, dp, s);
        if (i + 1 < s.length() 
            && (s.charAt(i) == '1' 
                || (s.charAt(i) == '2' 
                && (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0' ) <= 26))) {
            res += dfs(i + 2, dp, s);
        }
        dp[i] = res;
        return res;
    }
    
}