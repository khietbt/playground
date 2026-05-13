public class FirstUniqueCharacterInAString {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.firstUniqChar("leetcode"));
    System.out.println(solution.firstUniqChar("loveleetcode"));
  }
}

class Solution {
  public int firstUniqChar(String s) {
    var characters = new int[26];

    for (var i = 0; i < s.length(); i++) {
      characters[s.charAt(i) - 'a']++;
    }

    for (var i = 0; i < s.length(); i++) {
      if (characters[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }

    return -1;
  }
}
