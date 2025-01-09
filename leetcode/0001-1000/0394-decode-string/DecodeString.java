import java.util.Stack;

public class DecodeString {
  public static void main(String[] args) {
    // String encoded = "2[abc]3[cd]ef";
    String encoded = "a3[a2[c]]";

    System.out.println(new Solution().decodeString(encoded));
  }
}

class Solution {
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    int depth = 0;
    int digitStartingIndex = 0;
    int repetitions = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (depth == 0 && Character.isAlphabetic(c)) {
        sb.append(c);
        digitStartingIndex = i + 1;
      }

      if (c == '[') {
        depth++;

        if (depth == 1) {
          repetitions = Integer.valueOf(s.substring(digitStartingIndex, i));

          digitStartingIndex = i + 1;
        }
      }

      if (c == ']') {
        depth--;

        if (depth == 0) {
          String decoded = decodeString(s.substring(digitStartingIndex, i));

          while (repetitions-- > 0) {
            sb.append(decoded);
          }

          digitStartingIndex = i + 1;
        }
      }
    }

    return sb.toString();
  }
}
