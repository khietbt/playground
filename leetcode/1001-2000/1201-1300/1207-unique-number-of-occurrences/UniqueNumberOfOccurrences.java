import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
  public static void main(String[] args) {
    int[] numbers = new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };

    System.out.println(new Solution().uniqueOccurrences(numbers));
  }
}

class Solution {
  public boolean uniqueOccurrences(int[] numbers) {
    Map<Integer, Integer> m = new HashMap<>();

    for (int n : numbers) {
      m.merge(n, 1, Integer::sum);
    }

    Set<Integer> occurrences = new HashSet<>(m.values());

    return occurrences.size() == m.size();
  }
}
