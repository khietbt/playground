import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
  public static void main(String[] args) {
    System.out.println(new Solution().countPalindromicSubsequence("bbcbaba"));
  }
}

class Solution {
  public int countPalindromicSubsequence(String s) {
    int total = 0;

    for (char c = 'a'; c <= 'z'; c++) {
      int left = s.indexOf(c);
      int right = s.lastIndexOf(c);

      if (right > left) {
        Set<Character> middles = new HashSet<>();

        for (int i = left + 1; i < right && middles.size() < 26; i++) {
          middles.add(s.charAt(i));
        }

        total += middles.size();
      }
    }

    return total;
  }
}
