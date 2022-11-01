class Solution {
    public int[] findBall(int[][] grid) {
        int[] out = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i ++) {
            out[i] = helper(grid, i, 0);
        }       
        return out;
    }
    
    int helper(int[][] grid, int j, int i) {
        if (i == grid.length) {
            return j;
        }
        
        if (j > grid[0].length || j < 0) {
            return - 1;
        }
        //System.out.println(i  + " " + j);
        
        if (grid[i][j] == 1 && j + 1 < grid[0].length && grid[i][j] == grid[i][j + 1]) {
            return helper(grid, j + 1, i + 1);
        } else if (grid[i][j] == -1 && j - 1 >= 0 && grid[i][j] == grid[i][j - 1]) {
            return helper(grid, j - 1, i + 1);
        } else {
            return -1;
        } 
    }
}