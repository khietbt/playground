import java.util.Arrays;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("baaaadbad"));
  }
}

class Solution {
  public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] m = new boolean[n][n];

    // All single character string is palindrome
    for (boolean[] row : m) {
      Arrays.fill(row, true);
    }

    int maxLength = 1;
    int startIndex = 0;

    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        m[i][j] = false;

        if (s.charAt(i) == s.charAt(j)) {
          m[i][j] = m[i + 1][j - 1];

          if (m[i][j] && maxLength < j - i + 1) {
            maxLength = j - i + 1;
            startIndex = i;
          }
        }
      }
    }

    return s.substring(startIndex, startIndex + maxLength);
  }
}
