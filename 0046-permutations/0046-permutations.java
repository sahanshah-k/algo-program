class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int n: nums) {
            list.add(n);
        }
        helper(list, new ArrayList<Integer>(), perms);
        return perms;
    }
    
    void helper(List<Integer> nums, List<Integer> perm, List<List<Integer>> perms) {
        if (nums.isEmpty()) {
            perms.add(perm);
        } else {
            for (int i = 0; i < nums.size(); i ++) {
                List<Integer> newNums = new ArrayList<>(nums);
                newNums.remove(i);
                List<Integer> newPerm = new ArrayList<>(perm);
                newPerm.add(nums.get(i));
                helper(newNums, newPerm, perms);
            }
        }
    }
}