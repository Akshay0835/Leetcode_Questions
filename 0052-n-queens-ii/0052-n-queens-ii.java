class Solution {

    static boolean issafe(int row, int col, int board[][]) {

        int c = col;
        while (c >= 0) {
            if (board[row][c] == 1) {
                return false;
            }
            c--;
        }


        int r = row;
        c = col;

        while (r >= 0 && c >= 0) {
            if (board[r][c] == 1) {
                return false;
            }
            r--;
            c--;
        }

        r = row;
        c = col;

        while (r < board.length && c >= 0) {
            if (board[r][c] == 1) {
                return false;
            }
            r++;
            c--;
        }

        return true;
    }

    static int solve(int n, int col, int board[][]) {

        if (col >= n) {
            return 1;
        }

        int count = 0;

        for (int row = 0; row < n; row++) {

            if (issafe(row, col, board)) {

                board[row][col] = 1;

                count += solve(n, col + 1, board);

                board[row][col] = 0;
            }
        }

        return count;
    }

    public int totalNQueens(int n) {

        int board[][] = new int[n][n];

        return solve(n, 0, board);
    }
}