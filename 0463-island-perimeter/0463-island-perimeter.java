class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int perimeter = 0;

        // Iterate through all cells in the grid 🗺️
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // Process only land cells 🏝️
                if (grid[i][j] == 1) {
                    // Check - UP ⬆️
                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }
                    // Check - DOWN ⬇️
                    if (i == row - 1 || grid[i + 1][j] == 0) {
                        perimeter++;
                    }
                    // Check - LEFT ⬅️
                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }
                    // Check - RIGHT ➡️
                    if (j == col - 1 || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}