public class CheckIfArrayIsSortedAndRotated {
  public static void main(String[] args) {
    System.out.println(new Solution().check(new int[] { 3, 1, 2, 3, 4 }));
  }
}

class Solution {
  public boolean check(int[] nums) {
    if (nums.length < 3) {
      return true;
    }

    int obstacles = 0;

    if (nums[0] < nums[nums.length - 1]) {
      obstacles++;
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1]) {
        obstacles++;

        if (obstacles > 1) {
          return false;
        }
      }
    }

    return true;
  }
}
