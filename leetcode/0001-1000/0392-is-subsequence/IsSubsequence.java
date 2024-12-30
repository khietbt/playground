public class IsSubsequence {

  public static void main(String[] args) {
    System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
  }
}

class Solution {
  public boolean isSubsequence(String s, String t) {
    int i = 0;
    int j = 0;
    int n = s.length();
    int m = t.length();

    while (i < n && j < m) {
      if (s.charAt(i) == t.charAt(j)) {
        i++;
      }

      j++;
    }

    return i == n;
  }
}