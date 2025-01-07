public class ShiftingLettersII {
  public static void main(String[] args) {
    String s = "abc";
    int[][] shifts = {
        { 0, 1, 0 },
        { 1, 2, 1 },
        { 0, 2, 1 }
    };

    System.out.println(new Solution().shiftingLetters(s, shifts));
  }
}

class Solution {
  public String shiftingLetters(String s, int[][] shifts) {
    int[] changes = new int[s.length() + 1];
    int n = s.length();

    for (int[] shift : shifts) {
      int left = shift[0];
      int right = shift[1];
      int direction = shift[2] == 1 ? 1 : -1;

      changes[left] += direction;
      changes[right + 1] -= direction;
    }

    for (int i = 1; i <= n; i++) {
      changes[i] += changes[i - 1];
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int c = ((s.charAt(i) - 'a' + changes[i]) % 26 + 26) % 26;

      sb.append((char) (c + 'a'));
    }

    return sb.toString();
  }
}
