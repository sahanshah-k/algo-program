class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        helper(0, nums, out, new ArrayList<>());
        return out;
    }
    
    void helper(int i, int nums[], List<List<Integer>> list, List<Integer> sub) {
        if (i >= nums.length) {
            list.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        helper(i + 1, nums, list, sub);
        sub.remove(Integer.valueOf(nums[i]));
        helper(i + 1, nums, list, sub);
    }
}