import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInAString {
  public static void main(String[] args) {
    System.out.println(
        new Solution().reverseWords("the sky is     blue"));
  }
}

class Solution {
  public String reverseWords(String s) {
    List<String> parts = Arrays.asList(s.trim().split("\s+"));

    Collections.reverse(parts);

    return parts.stream().collect(Collectors.joining(" "));
  }
}
