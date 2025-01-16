import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
  public static void main(String[] args) {
    // int[] asteroids = { 5, 10, -5 };
    int[] asteroids = { 10, 2, -5 };

    System.out.println(Arrays.toString(new Solution().asteroidCollision(asteroids)));
  }
}

class Solution {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> queue = new ArrayDeque<>();

    for (int asteroid : asteroids) {
      if (asteroid > 0) {
        queue.offerLast(asteroid);
      } else {
        while (!queue.isEmpty() && queue.peekLast() > 0 && queue.peekLast() < -asteroid) {
          queue.pollLast();
        }

        if (!queue.isEmpty() && queue.peekLast() == -asteroid) {
          queue.pollLast();
        } else if (queue.isEmpty() || queue.peekLast() < 0) {
          queue.offerLast(asteroid);
        }
      }
    }

    return queue.stream().mapToInt(Integer::valueOf).toArray();
  }
}
