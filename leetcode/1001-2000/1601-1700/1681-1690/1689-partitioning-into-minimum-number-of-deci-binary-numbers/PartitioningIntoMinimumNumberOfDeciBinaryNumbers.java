public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minPartitions("82734"));
    System.out.println(solution.minPartitions("27346209830709182346"));
  }
}

class Solution {
  public int minPartitions(String n) {
    var minimum = 0;

    for (var i = 0; i < n.length() && minimum < 9; i++) {
      minimum = Math.max(minimum, n.charAt(i) - '0');
    }

    return minimum;
  }
}
