public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    System.out.println(new Solution().lengthOfLongestSubstring("abcabcab"));
  }
}

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int max = 1;
    int i = 0;

    StringBuilder sb = new StringBuilder();

    while (max < 26 && i < s.length()) {
      char c = s.charAt(i);

      int previousOccurrence = sb.indexOf(String.valueOf(c));

      if (previousOccurrence >= 0) {
        sb.delete(0, previousOccurrence + 1);
      }

      sb.append(c);

      // Next round
      max = Math.max(max, sb.length());
      i++;
    }
    return max;
  }
}
