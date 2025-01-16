public class RomanToInteger {
  public static void main(String[] args) {
    System.out.println(new Solution().romanToInt("III"));
  }
}

class Solution {
  public int romanToInt(String s) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    int i = 0;
    int v = 0;

    for (int j = 0; j < symbols.length; j++) {
      while (i < s.length() && i + symbols[j].length() <= s.length()
          && symbols[j].equals(s.substring(i, i + symbols[j].length()))) {
        v += values[j];
        i += symbols[j].length();
      }
    }

    return v;
  }
}
