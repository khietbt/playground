public class CountPrefixAndSuffixPairsI {
  public static void main(String[] args) {
    // String[] words = { "a", "aba", "ababa", "aa" };
    String[] words = { "abab", "ab" };

    System.out.println(new Solution().countPrefixSuffixPairs(words));
  }
}

class Solution {
  public int countPrefixSuffixPairs(String[] words) {
    int totalPrevfixSuffixPairs = 0;

    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
          totalPrevfixSuffixPairs++;
        }
      }
    }

    return totalPrevfixSuffixPairs;
  }
}
