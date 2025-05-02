import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
  public static void main(String[] args) {
    String[] words1 = new String[] { "amazon", "apple", "facebook", "google", "leetcode" };
    String[] words2 = new String[] { "e", "o" };

    System.out.println(new Solution().wordSubsets(words1, words2));
  }
}

class Solution {
  int[] convert(String[] words) {
    int[] characters = new int[26];

    for (String word : words) {
      int[] temp = convert(word);

      for (int i = 0; i < 26; i++) {
        characters[i] = Math.max(characters[i], temp[i]);
      }
    }

    return characters;
  }

  int[] convert(String s) {
    int[] characters = new int[26];

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      characters[c - 'a']++;
    }

    return characters;
  }

  boolean isValid(int[] characters, int[] max) {
    for (int i = 0; i < 26; i++) {
      if (characters[i] < max[i]) {
        return false;
      }
    }

    return true;
  }

  public List<String> wordSubsets(String[] words1, String[] words2) {
    int[] max = convert(words2);

    List<String> results = new ArrayList<>();

    for (String word : words1) {
      int[] characters = convert(word);

      if (isValid(characters, max)) {
        results.add(word);
      }
    }

    return results;
  }
}
