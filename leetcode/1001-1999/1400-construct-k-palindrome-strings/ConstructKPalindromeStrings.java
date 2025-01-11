public class ConstructKPalindromeStrings {
  public static void main(String[] args) {
    String s = "annabelle";
    int k = 2;

    System.out.println(new Solution().canConstruct(s, k));
  }
}

class Solution {
  public boolean canConstruct(String s, int k) {
    if (s.length() < k) {
      return false;
    }

    int totalOddCharacters = 0;

    int[] characters = new int[26];

    for (int i = 0; i < s.length(); i++) {
      characters[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < characters.length; i++) {
      totalOddCharacters += characters[i] % 2;
    }

    return totalOddCharacters <= k;
  }
}
