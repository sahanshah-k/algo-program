class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solveTab(nums);
    }
    
//     private int solveMem(int[] nums, int n, int[] dp) {
//         if (n < 0) {
//             return 0;
//         } 
//         if (n == 0) {
//             return nums[0];
//         }
//         if (dp[n] != -1) {
//             return dp[n];
//         }
//         int incl = solve(nums, n - 2, dp) + nums[n];        
//         int excl = solve(nums, n - 1, dp) + 0;
        
//         dp[n] = Math.max(incl, excl);
        
//         return dp[n];
//     }
    
    private int solveTab(int[] nums) {
        
        int[] dp = new int[nums.length];
        
        dp[0] = nums[0];
        
        for (int i = 1; i < nums.length; i ++) {
            int incl = i >= 2 ? dp[i - 2] + nums[i] : nums[i];
            int excl = dp[i - 1] + 0;
            dp[i] = Math.max(incl, excl);
        }
        
        return dp[nums.length - 1];
        
    }
}