class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        Arrays.fill(visited, false);
        
        int count = 0;
        for (int i = 0; i < isConnected.length; i ++) {
            if (!visited[i]) {
                count ++;
                dfs(isConnected, visited, i);
            }    
        }
        return count;
    }
    
    void dfs(int[][] isConnected, boolean[] visited, int node) {
        for (int i = 0; i < isConnected.length; i ++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                visited[node] = true;
                dfs(isConnected, visited, i);
            }
        }
    }
}