class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int[][] pacific = new int[heights.length][heights[0].length];
        int[][] atlantic = new int[heights.length][heights[0].length];
        
        //top and bottom
        for (int i = 0; i < heights[0].length; i ++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
            dfs(heights, heights.length - 1, i, Integer.MIN_VALUE, atlantic);
        }
        
        //left and right
        for (int i = 0; i < heights.length; i ++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
            dfs(heights, i, heights[0].length - 1, Integer.MIN_VALUE, atlantic);
        }
        
        List<List<Integer>> out = new ArrayList<>();
        
        for (int i = 0; i < heights.length; i ++) {
            for (int j = 0; j < heights[0].length; j ++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    out.add(Arrays.asList(i, j));
                }
            }
        }
        
        return out;
    }
    
    void dfs(int[][] h, int i, int j, int prevValue, int[][] ocean) {
        if (isOutside(i, j, h)) {
            return;
        } else if (h[i][j] < prevValue) {
            return;
        } else if (ocean[i][j] == 1) {
            return;
        }
        
        ocean[i][j] = 1;
                
        dfs(h, i - 1, j, h[i][j], ocean);        
        dfs(h, i + 1, j, h[i][j], ocean);
        dfs(h, i, j - 1, h[i][j], ocean);        
        dfs(h, i, j + 1, h[i][j], ocean);
    }
    
    boolean isOutside(int i, int j, int[][] h) {
        return i < 0 || j < 0 || i > (h.length - 1) || j > (h[0].length - 1);
    }
}