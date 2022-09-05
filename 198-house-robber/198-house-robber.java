class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] inclDp = new int[nums.length];
        Arrays.fill(inclDp, -1);
        int[] exclDp = new int[nums.length];
        Arrays.fill(exclDp, -1);
        return solve(nums, n - 1, inclDp, exclDp);
    }
    
    private int solve(int[] nums, int n, int[] inclDp, int[] exclDp) {
        if (n < 0) {
            return 0;
        } 
        if (n == 0) {
            return nums[0];
        }
        int incl = 0;
        if (inclDp[n] == -1) {
            incl = solve(nums, n - 2, inclDp, exclDp) + nums[n];
            inclDp[n] = incl;
        } else {
            incl = inclDp[n];
        }
        
        int excl = 0;
        if (exclDp[n] == -1) {
            excl = solve(nums, n - 1, inclDp, exclDp) + 0;
            exclDp[n] = excl;   
        } else {
            excl = exclDp[n];
        }
        
        return Math.max(incl, excl);
        
    }
}