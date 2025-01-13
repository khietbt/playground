public class MinimumLengthOfStringAfterOperations {
  public static void main(String[] args) {
    System.out.println(new Solution().minimumLength("abaacbcbba"));
  }
}

class Solution {
  public int minimumLength(String s) {
    int[] totalCharacters = new int[26];

    for (int i = 0; i < s.length(); i++) {
      totalCharacters[s.charAt(i) - 'a']++;
    }

    int l = 0;

    for (int i = 0; i < 26; i++) {
      if (totalCharacters[i] > 0) {
        l += (totalCharacters[i] % 2 == 0) ? 2 : 1;
      }
    }

    return l;
  }
}
