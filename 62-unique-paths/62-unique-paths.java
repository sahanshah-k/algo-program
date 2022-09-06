import java.util.Arrays;
/*
Using Combination
if we consider matrix 3X2
then from start to end we should move 2 blocks right and 1 block down (00 to 22)
ie m - 1 right and n - 1 down,
ie m + n - 2 number of steps to reach end
so we just need to fill _ _ _, these spaces from 2 rights or 1 down
here we just need to find 3C2 or 3C1,
so (m + n - 2) C (m - 1) or (m + n - 2) C (n - 1)
*/
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i ++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(m, n, 0, 0, dp);
    }
    
    private int helper(int m, int n, int x, int y, int[][] dp) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (x > m - 1 || y > n - 1) {
            return 0;
        }
        
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        int goDown = helper(m, n, x + 1, y, dp);
        int goRight = helper(m, n, x, y + 1, dp);
        dp[x][y] = goDown + goRight;
        return dp[x][y];
    }
}