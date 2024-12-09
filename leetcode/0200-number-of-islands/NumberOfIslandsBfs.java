import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIslandsBfs {
  public static void main(String[] args) {
    // char[][] grid = {
    // { '1', '1', '1', '1', '0' },
    // { '1', '1', '0', '1', '0' },
    // { '1', '1', '0', '0', '0' },
    // { '0', '0', '0', '0', '0' }
    // };

    char[][] grid = {
        { '1', '1', '0', '0', '0' },
        { '1', '1', '0', '0', '0' },
        { '0', '0', '1', '0', '0' },
        { '0', '0', '0', '1', '1' }
    };

    System.out.println((new Solution()).numIslands(grid));
  }
}

class Solution {
  private void visit(char[][] grid, int i, int j) {
    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';

    visit(grid, i, j + 1);
    visit(grid, i + 1, j);
    visit(grid, i - 1, j);
    visit(grid, i, j - 1);
  }

  public int numIslands(char[][] grid) {
    int numberOfIslands = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '0') {
          continue;
        }

        visit(grid, i, j);

        numberOfIslands++;
      }
    }

    return numberOfIslands;
  }
}
