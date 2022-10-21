class Solution {
    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     HashMap<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i ++) {
    //         if (map.containsKey(nums[i])) {
    //             int diff = Math.abs(map.get(nums[i]) - i);
    //             if (diff <= k) {
    //                 return true;
    //             } else if (diff > k) {
    //                 map.put(nums[i], i);
    //             }
    //         } else {
    //             map.put(nums[i], i);
    //         }
    //     }
    //     return false;
    // }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            Integer index = map.put(nums[i], i);
            if (index != null && Math.abs(index - i) <= k) {
                return true;
            }
        }
        return false;
    }
}