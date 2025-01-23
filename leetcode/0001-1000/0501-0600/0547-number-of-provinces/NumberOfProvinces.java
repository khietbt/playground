import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class NumberOfProvinces {
  public static void main(String[] args) {
    int[][] isConnected = new int[][] {
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
        { 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
        { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
        { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
        { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
        { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 } };

    System.out.println(new Solution().findCircleNum(isConnected));

  }
}

class Solution {
  public int findCircleNum(int[][] isConnected) {
    boolean[] seens = new boolean[isConnected.length];

    int totalProvinces = 0;

    for (int i = 0; i < seens.length; i++) {
      if (seens[i]) {
        continue;
      }

      Stack<Integer> stack = new Stack<>();
      stack.push(i);

      while (!stack.isEmpty()) {
        int city = stack.pop();

        if (seens[city]) {
          continue;
        }

        seens[city] = true;

        for (int j = 0; j < isConnected[city].length; j++) {
          if (!seens[j] && isConnected[city][j] == 1) {
            stack.push(j);
          }
        }
      }

      totalProvinces++;
    }

    return totalProvinces;
  }
}
