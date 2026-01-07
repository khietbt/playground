public class FindWordsThatCanBeFormedByCharacters {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.countCharacters(
            new String[] { "cat", "bt", "hat", "tree" },
            "atach"));

    System.out.println(
        solution.countCharacters(
            new String[] { "hello", "world", "leetcode" },
            "welldonehoneyr"));
  }
}

class Solution {

  int[] characters(String s) {
    int characters[] = new int[26];

    for (var i = 0; i < s.length(); i++) {
      characters[s.charAt(i) - 'a']++;
    }

    return characters;
  }

  boolean isValid(String s, int[] t) {
    return isValid(characters(s), t);
  }

  boolean isValid(int[] s, int[] t) {
    for (var i = 0; i < 26; i++) {
      if (s[i] > t[i]) {
        return false;
      }
    }

    return true;
  }

  public int countCharacters(String[] words, String chars) {
    var t = characters(chars);
    var sum = 0;

    for (var w : words) {
      if (isValid(w, t)) {
        sum += w.length();
      }
    }

    return sum;
  }
}
