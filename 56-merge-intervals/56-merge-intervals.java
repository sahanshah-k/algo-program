class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> out = new ArrayList<>();
        
        int[] currentInterval = intervals[0];
        out.add(currentInterval);

        for (int i = 1; i < intervals.length; i ++) {
            int currentBegin = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextBegin = intervals[i][0];
            int nextEnd = intervals[i][1];
            
            if (currentEnd >= nextBegin) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = intervals[i];
                out.add(currentInterval);
            }
            
        }
        return out.toArray(new int[out.size()][]);
    }
    
}