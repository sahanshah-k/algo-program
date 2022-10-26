class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        int val = 0;
        for (int i = 0; i < nums.length; i ++) {
            val += nums[i];
            int r = val % k;
            if (!map.containsKey(r)) {
                map.put(r, i);
            } else if (i - map.getOrDefault(r, 0) > 1) {
                return true;
            }
        }
        return false;
    }
}