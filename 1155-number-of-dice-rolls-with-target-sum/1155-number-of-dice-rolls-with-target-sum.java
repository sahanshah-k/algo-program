class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i ++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(n, target, k, dp);
    }
    
    int helper(int dice, int target, int faces, int[][] dp) {
        
        if (target < 0) {
            return 0;
        }
        
        if (dice == 0 && target != 0) {
            return 0;
        }
        
        if (target == 0 && dice != 0) {
            return 0;
        }
        
        if (target == 0 && dice == 0) {
            return 1;
        }
        
        if (dp[dice][target] != -1) {
            return dp[dice][target];
        }
        
        int sum = 0;
        for (int i = 1; i <= faces; i ++) {
            sum += helper(dice - 1, target - i, faces, dp);
            sum %= 1000000007;
        }
        dp[dice][target] = sum;
        return sum;
    }
}