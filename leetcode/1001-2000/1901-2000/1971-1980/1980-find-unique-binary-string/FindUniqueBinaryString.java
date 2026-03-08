public class FindUniqueBinaryString {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.findDifferentBinaryString(new String[] {
        "111", "011", "001"
    }));
  }
}

class Solution {
  public String findDifferentBinaryString(String[] nums) {
    var sb = new StringBuilder();

    for (var i = 0; i < nums.length; i++) {
      sb.append(nums[i].charAt(i) == '0' ? "1" : "0");
    }

    return sb.toString();
  }
}
