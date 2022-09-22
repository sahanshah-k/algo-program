class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) { //1,5
        List<Integer[]> out = new ArrayList<>();
        for (int i = 0; i < intervals.length; i ++) {
            if (newInterval[1] < intervals[i][0]) {
                out.add(new Integer[]{newInterval[0], newInterval[1]});
                for (int j = i; j < intervals.length; j ++) {
                    out.add(new Integer[]{intervals[j][0], intervals[j][1]});
                }
                return answer(out);
            } else if (newInterval[0] > intervals[i][1]) {
                out.add(new Integer[]{intervals[i][0], intervals[i][1]});
            } else {
                newInterval = new int[]{
                    Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])
                };
            }
        }
        out.add(new Integer[]{newInterval[0], newInterval[1]});
        return answer(out);
    }
    
    int[][] answer(List<Integer[]> out) {
        int[][] outArray = new int[out.size()][2];
        for (int i = 0; i < out.size(); i ++) {
            outArray[i][0] = out.get(i)[0];
            outArray[i][1] = out.get(i)[1];
        }
        return outArray;
    }
    
}