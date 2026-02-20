import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class SpecialBinaryString {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.makeLargestSpecial("11011000"));
  }
}

class Solution {
  public String makeLargestSpecial(String s) {
    var substrings = new ArrayList<String>();
    var balance = 0;
    var start = 0;

    for (var i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        balance++;
      } else {
        balance--;
      }

      if (balance != 0) {
        continue;
      }

      var inner = s.substring(start + 1, i);
      var largetInner = makeLargestSpecial(inner);

      substrings.add("1" + largetInner + "0");
      start = i + 1;
    }

    substrings.sort(Collections.reverseOrder());

    return substrings.stream().collect(Collectors.joining());
  }
}
