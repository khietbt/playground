import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    var answer = new ArrayList<List<Integer>>();

    var previous = Arrays.asList(1);

    answer.add(previous);

    for (var i = 1; i < numRows; i++) {
      var current = new ArrayList<Integer>();
      current.add(1);

      for (var j = 1; j < previous.size(); j++) {
        current.add(previous.get(j - 1) + previous.get(j));
      }

      current.add(1);

      answer.add(current);

      previous = current;
    }

    return answer;
  }
}
