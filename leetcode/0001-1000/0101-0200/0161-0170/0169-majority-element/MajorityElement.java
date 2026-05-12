public class MajorityElement {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2,}));
  }
}

class Solution {
  public int majorityElement(int[] nums) {
    var count = 0;
    var majority = 0;

    for (var n : nums) {
      if (count == 0) {
        majority = n;
      }

      if (majority == n) {
        count++;
      } else {
        count--;
      }
    }

    return majority;
  }
}
