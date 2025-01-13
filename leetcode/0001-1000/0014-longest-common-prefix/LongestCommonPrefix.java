public class LongestCommonPrefix {
  public static void main(String[] args) {
    String[] strings = { "flower", "flow", "flight" };

    System.out.println(new Solution().longestCommonPrefix(strings));
  }
}

class Solution {
  public String longestCommonPrefix(String[] strs) {
    int[] characters = new int[200];

    for (String s : strs) {
      int i = 0;

      while (i < s.length() && i < strs[0].length() && s.charAt(i) == strs[0].charAt(i)) {
        characters[i]++;
        i++;
      }
    }

    int i = 0;

    while (characters[i] == strs.length) {
      i++;
    }

    return strs[0].substring(0, i);
  }
}
