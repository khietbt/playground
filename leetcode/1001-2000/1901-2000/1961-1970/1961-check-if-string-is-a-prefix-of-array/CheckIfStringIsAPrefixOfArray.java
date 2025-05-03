public class CheckIfStringIsAPrefixOfArray {
  public static void main(String[] args) {
    String s = "iloveleetcode";
    String[] words = { "i", "love", "leetcode", "apples" };

    System.out.println(new Solution().isPrefixString(s, words));
  }
}

class Solution {
  public boolean isPrefixString(String s, String[] words) {
    int j = 0;

    for (int i = 0; i < words.length && j < s.length(); i++) {
      String left = words[i];

      if (s.length() < j + left.length()) {
        return false;
      }

      String right = s.substring(j, j + left.length());

      if (!left.equals(right)) {
        return false;
      }

      j = j + left.length();
    }

    return j == s.length();
  }
}
