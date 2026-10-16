class Solution {
    private static final int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private void dfs(int grid[][], int row, int col, boolean visited[][]) {
        visited[row][col] = true;
        for(int dir[] : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && !visited[newRow][newCol] && grid[newRow][newCol] == 1) dfs(grid, newRow, newCol, visited);
        }
    }
    private int count(int grid[][]) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++) for(int j = 0; j < grid[0].length; j++) if(!visited[i][j] && grid[i][j] == 1) { count++; dfs(grid, i, j, visited); }
        return count;
    }
    public int minDays(int[][] grid) {
        int count = count(grid);
        if(count != 1) return 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(count(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}