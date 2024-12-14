public class CountingWordsWithAGivenPrefix {

  public static void main(String[] args) {
    String[] words = { "pay", "attention", "practice", "attend" };
    String pref = "at";

    System.out.println((new Solution()).prefixCount(words, pref));
  }
}

class Solution {
  public int prefixCount(String[] words, String pref) {
    int count = 0;

    for (String word : words) {
      if (word.startsWith(pref)) {
        count++;
      }
    }

    return count;
  }
}