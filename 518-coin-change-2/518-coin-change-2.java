class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int c: coins) {
            for (int i = 1; i <= amount; i ++) {
                if (i >= c) {
                    dp[i] += dp[i - c];
                }
            }
        }
        return dp[amount];
    }
}