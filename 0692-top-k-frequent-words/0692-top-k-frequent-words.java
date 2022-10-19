class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        TreeMap<Integer, PriorityQueue<String>> treeMap = new TreeMap<>((a,b) -> b - a);
        
        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        for (Map.Entry<String, Integer> m: map.entrySet()) {
            PriorityQueue<String> pq = treeMap.getOrDefault(m.getValue(), new PriorityQueue<String>());
            pq.add(m.getKey());
            treeMap.put(m.getValue(), pq);
        }
        List<String> out = new ArrayList<>();
        for (PriorityQueue<String> q: treeMap.values()) {
            while(!q.isEmpty() && k > 0) {
                out.add(q.remove());
                k --;
            }
        }
        return out;
    }
}