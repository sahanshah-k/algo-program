class Solution {
    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] first = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] second = Arrays.copyOfRange(nums, 1, nums.length );

        int[] dp = new int[first.length];
        Arrays.fill(dp, -1);
        int firstMax = solve(first, first.length - 1, dp);
        
        Arrays.fill(dp, -1);
        int secondMax = solve(second, second.length - 1, dp);
    
        
        return Math.max(firstMax, secondMax);
        
        //if first value is passing then last value should be skipped
        //if last value is passing then first value should be skipped
        //So we will find first find out from first to last - 1 value
        //and out from second to last value and take max.
    }
    
    private int solve(int[] nums, int n, int[] dp) {
        if (n < 0) {
            return 0;
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