class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> treeMap = new TreeMap<>((a,b) -> b - a);
        
        for (int n: nums) {
            map.put(n,map.getOrDefault(n, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> mp: map.entrySet()) {
            List<Integer> list = treeMap.getOrDefault(mp.getValue(), new ArrayList<>());
            list.add(mp.getKey());
            treeMap.put(mp.getValue(), list);
        }
        
        int out[] = new int[k];
        int i = 0;
        
        for (List<Integer> list: treeMap.values()) {
            if (i == k) {
                break;
            }
            for (int n: list) {
                out[i] = n;
                i ++;
            }
        }
        return out;
        
    }
}