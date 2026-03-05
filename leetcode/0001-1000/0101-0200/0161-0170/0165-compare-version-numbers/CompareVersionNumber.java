import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersionNumber {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.compareVersion("1.2", "1.10"));
    System.out.println(solution.compareVersion("1.20", "1.10"));
    System.out.println(solution.compareVersion("1.01", "1.001"));
  }
}

class Solution {
  private int compare(String[] v1, String[] v2) {
    return compare(
        Arrays.stream(v1).map(Integer::valueOf)
            .collect(Collectors.toList()),
        Arrays.stream(v2).map(Integer::valueOf)
            .collect(Collectors.toList()));
  }

  private int compare(List<Integer> v1, List<Integer> v2) {
    if (v1.size() < v2.size()) {
      return -compare(v2, v1);
    }

    while (v1.size() > v2.size()) {
      v2.add(0);
    }

    for (var i = 0; i < v1.size(); i++) {
      if (v1.get(i) > v2.get(i)) {
        return 1;
      } else if (v1.get(i) < v2.get(i)) {
        return -1;
      }
    }

    return 0;
  }

  public int compareVersion(String version1, String version2) {
    return compare(version1.split("\\."), version2.split("\\."));
  }
}
