/*

Kadane's Algorithm
- Iterate and add a[i] to sum,
- If sum < -1 make sum as 0
- If sum > max, set max = sum
*/



class Solution {
    public int maxSubArray(int[] nums) {
    
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = sum < 0 ? 0 : sum;
        }
        return max;
    
    }
}
