class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int i = 1; i <= target; i ++) {
            dp.put(i, 0);
            for (int n: nums) {
                dp.put(i, dp.get(i) + dp.getOrDefault(i - n, 0));
            }
        }
        return dp.get(target);
    }
}