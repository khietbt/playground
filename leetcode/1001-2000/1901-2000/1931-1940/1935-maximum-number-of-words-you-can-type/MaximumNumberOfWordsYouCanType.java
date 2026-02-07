import java.util.Arrays;
import java.util.HashSet;

public class MaximumNumberOfWordsYouCanType {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.canBeTypedWords("hello world", "ad"));
  }
}

class Solution {
  public int canBeTypedWords(String text, String brokenLetters) {
    var broken = new HashSet<Character>();
    for (var c : brokenLetters.toCharArray()) {
      broken.add(c);
    }

    return (int) Arrays.stream(text.split(" "))
        .filter(s -> s.chars().boxed().noneMatch(i -> broken.contains((char) i.intValue())))
        .count();
  }
}
