public class StringCompression {
  public static void main(String[] args) {
    System.out.println(new Solution().compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
  }
}

class Solution {
  public int compress(char[] chars) {
    StringBuilder sb = new StringBuilder();

    for (int i = 1, streak = 1; i <= chars.length; i++) {
      if (i < chars.length && chars[i] == chars[i - 1]) {
        streak++;

        continue;
      }

      sb.append(chars[i - 1]);

      if (streak > 1) {
        sb.append(streak);
      }

      streak = 1;
    }

    sb.getChars(0, sb.length(), chars, 0);

    return sb.length();
  }
}
