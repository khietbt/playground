import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDnaSequences {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").toString());
  }
}

class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    var sequences = new HashSet<String>();
    var faced = new HashSet<String>();

    for (var end = 10; end <= s.length(); end++) {
      var start = end - 10;
      var v = s.substring(start, end);

      if (sequences.contains(v)) {
        continue;
      }

      if (faced.contains(v)) {
        sequences.add(v);
        continue;
      }

      faced.add(v);
    }

    return new ArrayList<>(sequences);
  }
}
