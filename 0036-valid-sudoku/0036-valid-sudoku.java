import java.util.HashSet;

class Solution {

    public boolean isValidSudoku(char[][] board) {

        // Check rows
        for (int i = 0; i < 9; i++) {

            HashSet<Character> set = new HashSet<>();

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        // Check columns
        for (int j = 0; j < 9; j++) {

            HashSet<Character> set = new HashSet<>();

            for (int i = 0; i < 9; i++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        // Check 3 x 3 boxes
        for (int sr = 0; sr < 9; sr += 3) {

            int er = sr + 2;

            for (int sc = 0; sc < 9; sc += 3) {

                int ec = sc + 2;

                if (!traversal(board, sr, er, sc, ec)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean traversal(char[][] board, int sr, int er, int sc, int ec) {

        HashSet<Character> set = new HashSet<>();

        for (int i = sr; i <= er; i++) {

            for (int j = sc; j <= ec; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                if (set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        return true;
    }
}