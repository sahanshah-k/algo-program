class Solution {
    
    //naive solution sort and iterate nlogn
    
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> mem = new HashSet<>();
        
        for (int v : nums) {
            mem.add(v);
        }
        
        int max = 0;
        for (int v: nums) {
            int temp = v;
            if (!mem.contains(temp - 1)) {
                int count = 0;
                while (mem.contains(temp)) {
                    count ++;
                    temp ++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}