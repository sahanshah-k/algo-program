class Solution {
    public int numIslands(char[][] grid) {
        
        int r = grid.length;
        int c = grid[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        int count = 0;
        
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j ++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count ++;
                    dfs(grid, i, j, visited, r, c);
                }
            }
        }
        return count;
    }
    
    void dfs(char[][] grid, int i, int j, boolean[][] visited, int r, int c) {
        if (isOutside(i, j, r, c) || grid[i][j] == '0' || visited[i][j]) {
            return;
        }  
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited, r, c);
        dfs(grid, i, j + 1, visited, r, c);
        dfs(grid, i - 1, j, visited, r, c);
        dfs(grid, i, j - 1, visited, r, c);
    }
    
    boolean isOutside(int i, int j, int r, int c) {
        return i < 0 || j < 0 || i >= r || j >= c;
    }
}