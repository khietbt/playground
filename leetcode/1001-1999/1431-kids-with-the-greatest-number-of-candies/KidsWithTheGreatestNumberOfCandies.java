import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KidsWithTheGreatestNumberOfCandies {
  public static void main(String[] args) {
  }
}

class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    if (candies.length == 0) {
      return new ArrayList<Boolean>();
    }

    int max = Arrays.stream(candies).max().orElse(Integer.MIN_VALUE);
    int rhs = max - extraCandies;

    Function<Integer, Boolean> evaluate = c -> c >= rhs;

    return Arrays.stream(candies).mapToObj(evaluate::apply).collect(Collectors.toList());
  }
}
