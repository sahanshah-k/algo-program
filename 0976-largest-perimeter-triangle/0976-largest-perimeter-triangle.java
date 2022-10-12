class Solution {
    // a<=b<=c then a+b > c
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] + nums[i + 1] > nums[i + 2] && nums[i] + nums[i + 1] + nums[i + 2] > max) {
                max = nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}