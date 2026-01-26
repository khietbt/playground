import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.minimumAbsDifference(new int[] { 4, 2, 1, 3 }).toString());
    System.out.println(
        solution.minimumAbsDifference(new int[] { 3, 8, -10, 23, 19, -4, -14, 27 }).toString());
  }
}

class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);

    var answers = new ArrayList<List<Integer>>();

    var min = Integer.MAX_VALUE;

    for (var i = 0; i < arr.length - 1; i++) {
      min = Math.min(min, Math.abs(arr[i] - arr[i -= 1]));
    }

    for (var i = 0; i < arr.length - 1; i++) {
      var diff = Math.abs(arr[i] - arr[i + 1]);

      if (diff == min) {
        answers.add(Arrays.asList(arr[i], arr[i + 1]));
      }
    }

    return answers;
  }
}
