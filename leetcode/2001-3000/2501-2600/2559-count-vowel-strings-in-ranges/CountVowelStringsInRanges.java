import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class CountVowelStringsInRanges {
  public static void main(String[] args) {
    String[] words = new String[] { "aba", "bcb", "ece", "aa", "e" };
    int[][] queries = new int[][] { { 0, 2 }, { 1, 4 }, { 1, 1 } };

    System.out.println(Arrays.toString(new Solution().vowelStrings(words, queries)));
  }
}

class Solution {
  public int[] vowelStrings(String[] words, int[][] queries) {
    if (words.length == 0) {
      return new int[] {};
    }

    boolean[] characters = new boolean[26];
    Stream.of('a', 'e', 'i', 'o', 'u').forEach(c -> characters[c - 'a'] = true);

    Function<Character, Boolean> isVowel = (c) -> characters[c - 'a'];
    Function<String, Boolean> startsAndEndsWithVowel = (s) -> !s.isEmpty()
        && isVowel.apply(s.charAt(0))
        && isVowel.apply(s.charAt(s.length() - 1));

    // Evaluate
    int[] evaluated = new int[words.length];

    for (int i = 0; i < words.length; i++) {
      evaluated[i] = startsAndEndsWithVowel.apply(words[i]) ? 1 : 0;
    }

    // Accumulate
    int[] accumulated = new int[words.length + 1];

    for (int i = 0; i < words.length; i++) {
      accumulated[i + 1] = accumulated[i] + evaluated[i];
    }

    // Create results
    int[] results = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      int[] query = queries[i];
      int left = query[0];
      int right = query[1];

      results[i] = accumulated[right + 1] - accumulated[left];
    }

    return results;
  }
}
