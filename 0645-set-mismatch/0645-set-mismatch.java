class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ary = new int[nums.length + 1];
        int[] out = new int[2];
        for (int i = 0; i < nums.length; i ++) {
            if (ary[nums[i]] != 0) {
                out[0] = nums[i];
                //break;
            }
            ary[nums[i]] = nums[i];
        }
                
        for (int i = 1; i < nums.length + 1; i ++) {
            if (ary[i] == 0) {
                out[1] = i;
                break;
            }
        }
        
        return out;
    }
}