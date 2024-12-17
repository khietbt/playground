public class ConstructStringWithRepeatLimit {
  public static void main(String[] args) {
    String s = "aaaaaab";
    int repeatLimit = 3;

    System.out.println((new Solution()).repeatLimitedString(s, repeatLimit));
  }
}

class Solution {
  public String repeatLimitedString(String s, int repeatLimit) {
    int[] letters = new int[26];

    for (int i = 0; i < s.length(); i++) {
      letters[s.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();

    for (int currentCharacter = 25; currentCharacter >= 0; currentCharacter--) {
      int nextCharacter = currentCharacter - 1;

      while (true) {
        int k = Math.min(repeatLimit, letters[currentCharacter]);

        if (k <= 0) {
          break;
        }

        for (int i = 0; i < k; i++) {
          sb.append((char) (currentCharacter + 'a'));
          letters[currentCharacter]--;
        }
        if (letters[currentCharacter] <= 0) {
          break;
        }

        while (nextCharacter >= 0 && letters[nextCharacter] < 1) {
          nextCharacter--;
        }

        if (nextCharacter < 0) {
          break;
        }

        letters[nextCharacter]--;
        sb.append((char) ('a' + nextCharacter));
      }
    }

    return sb.toString();
  }
}
