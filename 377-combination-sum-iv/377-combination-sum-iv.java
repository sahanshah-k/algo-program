class Solution {
    
    private int helper(int[] nums, int target, int[] dp) { 
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        
        if (dp[target] != -1) {
            return dp[target];
        }
        
        int possibleCount = 0;
        for (int n: nums) {
            possibleCount += helper(nums, target - n, dp);
            dp[target] = possibleCount;
        }
        return possibleCount;
    }
    
    private int tabulation(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i ++) {
            dp[i] = 0;
            for (int n: nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
    
    public int combinationSum4(int[] nums, int target) {
        // int[] dp = new int[target + 1];
        // Arrays.fill(dp, -1);
        // return helper(nums, target, dp);
        return tabulation(nums, target);
    }
}