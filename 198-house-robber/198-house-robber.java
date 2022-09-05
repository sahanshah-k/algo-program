class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, n - 1, dp);
    }
    
    private int solve(int[] nums, int n, int[] dp) {
        if (n < 0) {
            return 0;
        } 
        if (n == 0) {
            return nums[0];
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int incl = solve(nums, n - 2, dp) + nums[n];        
        int excl = solve(nums, n - 1, dp) + 0;
        
        dp[n] = Math.max(incl, excl);
        
        return dp[n];
        
    }
}