class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    public int helper(int n, int[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
    
}