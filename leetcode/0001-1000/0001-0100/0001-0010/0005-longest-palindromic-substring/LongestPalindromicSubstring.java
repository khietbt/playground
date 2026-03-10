public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.longestPalindrome("a"));
    System.out.println(solution.longestPalindrome("bababd"));
    System.out.println(solution.longestPalindrome("abaabbccbba"));
  }
}

class Solution {
  public String longestPalindrome(String s) {
    var maximum = 0;
    var left = 0;
    var sb = new StringBuilder();
    var delimiter = '#';

    var n = s.length();
    for (var i = 0; i < n; i++) {
      sb.append(delimiter);
      sb.append(s.charAt(i));
    }
    sb.append(delimiter);

    for (var i = 0; i < sb.length(); i++) {
      var j = 0;

      while (i - (j + 1) >= 0 && i + j + 1 < sb.length() && sb.charAt(i - j - 1) == sb.charAt(i + j + 1)) {
        j++;
      }

      if (j > maximum) {
        maximum = j;
        left = i - j;
      }
    }

    return s.substring(left / 2, left / 2 + maximum);
  }
}
