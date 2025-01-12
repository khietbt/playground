public class CheckIfAParenthesesStringCanBeValid {
  public static void main(String[] args) {
    System.out.println(new Solution().canBeValid("))()))", "110100"));
  }
}

class Solution {
  public boolean canBeValid(String s, String locked) {
    if (s.length() % 2 == 1) {
      return false;
    }

    int totalValidCharacters = 0;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
        totalValidCharacters++;
      } else if (totalValidCharacters > 0) {
        totalValidCharacters--;
      } else {
        return false;
      }
    }

    totalValidCharacters = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
        totalValidCharacters++;
      } else if (totalValidCharacters > 0) {
        totalValidCharacters--;
      } else {
        return false;
      }
    }

    return true;
  }
}
