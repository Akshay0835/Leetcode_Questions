class Solution {

    public boolean validpath(int i, int j, int balance, char[][] grid,
                             int n, int m, int[][][] dp) {

        if (i >= n || j >= m) {
            return false;
        }

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        if (i == n - 1 && j == m - 1) {
            return balance == 0;
        }

        if (dp[i][j][balance] != -1) {
            return dp[i][j][balance] == 1;
        }

        boolean result = validpath(i + 1, j, balance, grid, n, m, dp)
                      || validpath(i, j + 1, balance, grid, n, m, dp);

        dp[i][j][balance] = result ? 1 : 0;

        return result;
    }

    public boolean hasValidPath(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][n + m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n + m; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return validpath(0, 0, 0, grid, n, m, dp);
    }
}