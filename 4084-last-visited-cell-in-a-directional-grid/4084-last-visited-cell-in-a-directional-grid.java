class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int row = 0;
        int col = 0;
        int lastrow = -1;
        int lastcol = -1;

        boolean[][] vis = new boolean[grid.length][grid[0].length];

        while (true) {
            int dir = grid[row][col];

            vis[row][col] = true;
            lastrow = row;
            lastcol = col;

            if (dir == 'U') row -= 1;
            else if (dir == 'D') row += 1;
            else if (dir == 'L') col -= 1;
            else if (dir == 'R') col += 1;

            if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length) break;

            if (vis[row][col]) break;
        }

        return new int[]{lastrow, lastcol};
    }
}