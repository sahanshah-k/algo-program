class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i ++) {
            dp[i] = 0;
            for (int n: nums) {
                dp[i] += (i - n) >= 0 && (i - n) <= target ? dp[i - n] : 0;
            }
        }
        return dp[target];
    }
}