//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merge = new LinkedList<>();
        
        for (int[] interval: intervals) {
            if (merge.isEmpty() || merge.getLast()[1] < interval[0]) {
                merge.add(interval);
            } else {
                merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
