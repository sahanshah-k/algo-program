class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                if (board[i][j] == word.charAt(0) && helper(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean helper(char[][] b, int i, int j, int k, String word, boolean[][] visited) {
        if (i < 0 || j < 0 || i > b.length - 1 || j > b[0].length - 1 || visited[i][j] || b[i][j] != word.charAt(k)) {
            return false;
        }
        
        visited[i][j] = true;

        if (k == word.length() - 1) {
            return true;
        }
        
        if (helper(b, i + 1, j, k + 1, word, visited)
            || helper(b, i, j + 1, k + 1, word, visited)
            || helper(b, i - 1, j, k + 1, word, visited)
            || helper(b, i, j - 1, k + 1, word, visited)) {
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}