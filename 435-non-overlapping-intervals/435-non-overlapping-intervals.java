class Solution {
    
    //[1,100],[1,11],[2,12],[11,22]
    
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->  a[0] - b[0]);
        
        int count = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i ++) {
            if (prevEnd > intervals[i][0]) {
                count ++;
                prevEnd = Math.min(prevEnd, intervals[i][1]);
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}