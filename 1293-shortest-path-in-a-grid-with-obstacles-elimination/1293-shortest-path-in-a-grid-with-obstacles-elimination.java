class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = new int[][] {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int steps = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while (size -- > 0) {
                int[] pop = q.remove();

                if (pop[0] == m - 1 && pop[1] == n - 1) {
                    return steps;
                }

                for (int i = 0; i < 4; i ++) {
                    int x = pop[0] + dir[i][0];
                    int y = pop[1] + dir[i][1];
                    int kV = pop[2];

                    if (isValidDirection(x, y, kV, m, n, grid, visited)) {
                        if (isValidNonBlock(x, y, kV, grid, visited)) {
                            q.add(new int[]{x, y, kV});
                            visited[x][y][kV] = true;
                        } else if (isValidBlock(x, y, kV, grid, visited)) {
                            q.add(new int[]{x, y, kV - 1});
                            visited[x][y][kV - 1] = true;
                        }
                    }
                }
            }
            steps ++;
        }
        return -1;
    }

    boolean isValidBlock(int x, int y, int k, int[][] grid, boolean visited[][][]) {
        return grid[x][y] == 1 && k > 0 && !visited[x][y][k - 1];
    }

    boolean isValidNonBlock(int x, int y, int k, int[][] grid, boolean visited[][][]) {
        return grid[x][y] == 0 && !visited[x][y][k];
    }

    boolean isValidDirection(int x, int y, int k, int m, int n, int[][] grid, boolean visited[][][]) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        } 
        if (visited[x][y][k]) {
            return false;
        } 
        return true;
    }
}