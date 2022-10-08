class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                
                if (sum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }
        return closest;
    }
}