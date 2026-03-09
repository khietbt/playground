import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.lengthOfLongestSubstring("ab"));
    System.out.println(solution.lengthOfLongestSubstring("ababc"));
  }
}

class Solution {
  public int lengthOfLongestSubstring(String s) {
    var maximum = 0;
    var data = new int[256];
    var j = -1;

    Arrays.fill(data, -1);

    for (var i = 0; i < s.length(); i++) {
      var current = s.charAt(i);

      j = Math.max(j, data[current]);

      maximum = Math.max(maximum, i - j);
      //
      data[s.charAt(i)] = i;
    }

    return maximum;
  }
}
