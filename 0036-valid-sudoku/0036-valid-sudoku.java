import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    continue;
                }

                char num = board[i][j];

                String row = num + "_ROW_" + i;
                String col = num + "_COL_" + j;
                String box = num + "_BOX_" + (i / 3) + "_" + (j / 3);

                if (set.contains(row) ||
                    set.contains(col) ||
                    set.contains(box)) {

                    return false;
                }

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;
    }
}