class Solution {
    public boolean canJump(int[] nums) {
        // int[] dp = new int[nums.length];
        // return helper(nums, 0, dp);
        return solve1(nums);
    }
    
    private boolean solve1(int[] nums) {
        int toJumpX = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i --) {
            int diff = toJumpX - i;
            if (nums[i] >= diff) {
                toJumpX = toJumpX - diff;
            }
        }
        return toJumpX == 0;
    }
    
//     private boolean helper(int[] nums, int x, int[] dp) {
        
//         System.out.println(Arrays.toString(dp));
        
//         if (x == nums.length - 1) {
//             return true;
//         }
//         if (x >= nums.length) {
//             return false;
//         }
        
//         if (dp[x] == 1) {
//             return true;
//         }
//         if (dp[x] == -1) {
//             return false;
//         }
        
//         boolean flag = false;
//         for (int i = 1; i <= nums[x]; i ++) {
//             flag = flag || helper(nums, i + x, dp);
//         }        
//         dp[x] = flag ? 1 : -1;
//         return flag;
//     }

}