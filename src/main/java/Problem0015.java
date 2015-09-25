/**
 * Starting in the top left corner of a 2x2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * <p>
 * How many such routes are there through a 20x20 grid?
 *
 * @author David Clutter
 */
public class Problem0015 {

    private static final int GRID_SIZE = 20;

    // Dynamic Backtrack
    public static void main(final String[] args) {
        final long[][] grid = new long[GRID_SIZE + 1][GRID_SIZE + 1];
        for (int i = GRID_SIZE; i >= 0; --i) {
            for (int j = GRID_SIZE; j >= 0; --j) {
                if (i == GRID_SIZE || j == GRID_SIZE) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i + 1][j] + grid[i][j + 1];
                }
            }
        }
        grid[GRID_SIZE][GRID_SIZE] = 0;
        System.out.print(grid[0][0]);
    }
}