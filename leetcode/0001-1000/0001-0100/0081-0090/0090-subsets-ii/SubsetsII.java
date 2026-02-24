import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.subsetsWithDup(new int[] { 1, 2, 2 }).toString());
  }
}

class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);

    var answer = new ArrayList<List<Integer>>();

    answer.add(List.of());
    answer.add(List.of(nums[0]));

    var processed = 1;

    for (var i = 1; i < nums.length; i++) {
      var start = nums[i] == nums[i - 1] ? processed : 0;
      processed = answer.size();

      var subsets = new ArrayList<List<Integer>>();

      for (var j = start; j < answer.size(); j++) {
        var subset = new ArrayList<Integer>(answer.get(j));
        subset.add(nums[i]);

        subsets.add(subset);
      }

      answer.addAll(subsets);
    }

    return answer;
  }
}
