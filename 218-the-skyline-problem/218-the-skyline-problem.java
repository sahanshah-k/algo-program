class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int[][] t = new int[buildings.length * 2][2];    
        transform(buildings, t);
        PriorityQueue<Integer> hq = new PriorityQueue<>((a, b) -> b - a);
        hq.offer(0);
        
        List<List<Integer>> out = new ArrayList<>();
        int prevMax = 0;
        for (int i = 0; i < t.length; i ++) {
            if (t[i][1] < 0) {
                hq.offer(-t[i][1]);
            } else {
                hq.remove(t[i][1]);
            }
            int currMax = hq.peek();
            if (prevMax != currMax) {
                out.add(Arrays.asList(t[i][0], currMax));
                prevMax = currMax;
            }
            
        }
        return out;
    }
    
    private void transform(int[][] b, int[][] t) {
        int j = 0;
        for (int i = 0; i < b.length; i ++) {
            t[j][0] = b[i][0];
            t[j][1] = -b[i][2];
            j ++;
            t[j][0] = b[i][1];
            t[j][1] = b[i][2];
            j ++;
        }
        Arrays.sort(t, (a1, a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);
    }
    
    
}