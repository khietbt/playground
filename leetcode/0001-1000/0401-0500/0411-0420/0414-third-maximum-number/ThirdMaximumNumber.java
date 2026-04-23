class Solution {
  public int thirdMax(int[] nums) {
    var first = Integer.MIN_VALUE;
    var second = Integer.MIN_VALUE;
    var third = Integer.MIN_VALUE;

    for (var n : nums) {
      if (n == first || n == second || n == third) {
        continue;
      }

      if (n > first) {
        third = second;
        second = first;
        first = n;
      } else if (n > second) {
        third = second;
        second = n;
      } else if (n > third) {
        third = n;
      }
    }

    return third == Integer.MIN_VALUE ? first : third;
  }
}
