import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
  public static void main(String[] args) {
    int[] lhs = { 1, 2, 3, 3 };
    int[] rhs = { 1, 1, 2, 2 };

    System.out.println(new Solution().findDifference(lhs, rhs));
  }
}

class Solution {
  private Set<Integer> toSet(int[] numbers) {
    Set<Integer> integers = new HashSet<>();

    for (int number : numbers) {
      integers.add(number);
    }

    return integers;
  }

  public List<List<Integer>> findDifference(int[] lhs, int[] rhs) {
    Set<Integer> left = toSet(lhs);
    Set<Integer> right = toSet(rhs);

    List<Integer> l1 = new ArrayList<>();

    for (int v : lhs) {
      if (right.add(v)) {
        l1.add(v);
      }
    }

    List<Integer> l2 = new ArrayList<>();

    for (int v : rhs) {
      if (left.add(v)) {
        l2.add(v);
      }
    }

    return Arrays.asList(l1, l2);
  }
}
