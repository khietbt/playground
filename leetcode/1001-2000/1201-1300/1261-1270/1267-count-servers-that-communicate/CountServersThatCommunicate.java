public class CountServersThatCommunicate {
  public static void main(String[] args) {
    int[][] grid = {
        { 1, 1, 0, 0 },
        { 0, 0, 1, 0 },
        { 0, 0, 1, 0 },
        { 0, 0, 0, 1 }
    };

    System.out.println(new Solution().countServers(grid));
  }
}

class Solution {
  public int countServers(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[] rows = new int[m];
    int[] columns = new int[n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          rows[i]++;
          columns[j]++;
        }
      }
    }

    int totalConnectedServers = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1 && (rows[i] > 1 || columns[j] > 1)) {
          totalConnectedServers++;
        }
      }
    }

    return totalConnectedServers;
  }
}
