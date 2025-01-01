public class MaximumNumberOfVowelsInASubstringOfGivenLength {
  public static void main(String[] args) {
    System.out.println(new Solution().maxVowels("leetcode", 3));
  }
}

class Solution {
  public int maxVowels(String s, int k) {
    if (s.isEmpty() || k == 0) {
      return 0;
    }

    int max = 0;
    final String vowels = "aoeiu";

    for (int i = 0; i < k; i++) {
      if (vowels.indexOf(s.charAt(i)) < 0) {
        continue;
      }

      max++;
    }

    int current = max;

    for (int i = k; i < s.length() && max < k; i++) {
      if (vowels.indexOf(s.charAt(i - k)) >= 0) {
        current--;
      }

      if (vowels.indexOf(s.charAt(i)) < 0) {
        continue;
      }

      current++;

      max = Math.max(current, max);
    }

    return max;
  }
}
