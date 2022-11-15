class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] longest = new int[nums.length];
        Arrays.fill(longest, 1);
        int maxLength = 1;
        for (int i = nums.length - 1; i >=0; i --) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] < nums[j]) {
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                    maxLength = Math.max(maxLength, longest[i]);
                }
            }
        }
        return maxLength;
    }
}