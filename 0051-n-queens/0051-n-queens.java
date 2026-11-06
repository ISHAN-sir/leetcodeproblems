class Solution {

    static boolean isSafe(char[][] board, int row, int col, int n) {

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int maxleft = Math.min(row, col);

        for (int i = 1; i <= maxleft; i++) {
            if (board[row - i][col - i] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        int maxright = Math.min(row, n - 1 - col);

        for (int i = 1; i <= maxright; i++) {
            if (board[row - i][col + i] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static List<String> makeString(char[][] board) {
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            temp.add(new String(board[i]));
        }

        return temp;
    }

    static void queen(char[][] board, int row, List<List<String>> ans, int n) {

        if (row == n) {
            ans.add(makeString(board));
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                board[row][col] = 'Q';

                queen(board, row + 1, ans, n);

                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();

        queen(board, 0, ans, n);

        return ans;
    }
}