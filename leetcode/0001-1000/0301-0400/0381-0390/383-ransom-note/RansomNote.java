public class RansomNote {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.canConstruct("a", "b"));
    System.out.println(solution.canConstruct("aa", "ab"));
    System.out.println(solution.canConstruct("aa", "aab"));
  }
}

class Solution {
  public boolean canConstruct(String ransomNote, String magazine) {
    var characters = new int[26];

    for (var c : magazine.toCharArray()) {
      characters[c - 'a']++;
    }

    for (var c : ransomNote.toCharArray()) {
      characters[c - 'a']--;
    }

    for (var c : characters) {
      if (c < 0) {
        return false;
      }
    }

    return true;
  }
}
