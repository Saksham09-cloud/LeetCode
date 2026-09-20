class Solution {

    boolean valid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }

    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    void dfs(char[][] grid, int i, int j, int n, int m, boolean[][] vis) {

        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {

            int row = i + x[k];
            int col = j + y[k];

            if (valid(row, col, n, m)
                    && grid[row][col] == '1'
                    && !vis[row][col]) {

                dfs(grid, row, col, n, m, vis);
            }
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !vis[i][j]) {

                    count++;

                    dfs(grid, i, j, n, m, vis);
                }
            }
        }

        return count;
    }
}