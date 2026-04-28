public class LengthOfLastWord {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.lengthOfLastWord("Hello World"));
    System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
    System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));

    System.out.println(solution.lengthOfLastWord(""));
    System.out.println(solution.lengthOfLastWord("    "));
  }
}

class Solution {
  public int lengthOfLastWord(String s) {
    var end = s.length() - 1;

    while (end >= 0 && s.charAt(end) == ' ') {
      end--;
    }

    var start = end;

    while (start >= 0 && s.charAt(start) != ' ') {
      start--;
    }

    return end - start;
  }
}
