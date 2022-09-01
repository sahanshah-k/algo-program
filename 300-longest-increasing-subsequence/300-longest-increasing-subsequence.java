class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[] longest = new int[nums.length];
        int[] seq = new int[nums.length];
        Arrays.fill(longest, 1);
        int maxLength = 1;
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    longest[i] = Math.max(longest[i], 1 + longest[j]);
                    seq[i] = j;
                    if (longest[i] > maxLength) {
                        maxLength = longest[i];
                    }
                }       
            }
        }
        return maxLength;
    }
}