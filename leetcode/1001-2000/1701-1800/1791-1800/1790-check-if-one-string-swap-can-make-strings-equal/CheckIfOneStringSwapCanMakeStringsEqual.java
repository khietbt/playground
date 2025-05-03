public class CheckIfOneStringSwapCanMakeStringsEqual {
  public static void main(String[] args) {
    String s1 = "bank";
    String s2 = "kanb";

    System.out.println(new Solution().areAlmostEqual(s1, s2));
  }
}

class Solution {
  public boolean areAlmostEqual(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    int[] differences = new int[26];
    int differenceCount = 0;

    for (int i = 0; i < s1.length() && differenceCount < 3; i++) {
      differences[s1.charAt(i) - 'a']++;
      differences[s2.charAt(i) - 'a']--;

      if (s1.charAt(i) != s2.charAt(i)) {
        differenceCount++;

        if (differenceCount > 2) {
          return false;
        }
      }
    }

    for (int i = 0; i < 26; i++) {
      if (differences[i] != 0) {
        return false;
      }
    }

    return true;
  }
}
