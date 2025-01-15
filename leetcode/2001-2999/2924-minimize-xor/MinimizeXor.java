public class MinimizeXor {
  public static void main(String[] args) {
    // System.out.println(new Solution().minimizeXor(25, 72));
    // System.out.println(new Solution().minimizeXor(79, 74));
    System.out.println(new Solution().minimizeXor(65, 84));
  }
}

class Solution {
  public int minimizeXor(int num1, int num2) {
    // System.out.println("###################");
    int n = Integer.bitCount(num2);

    String binary = Integer.toBinaryString(num1);

    // System.out.println(binary);
    // System.out.println(n);

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < binary.length(); i++) {
      if (binary.charAt(i) == '1' && n > 0) {
        n--;
        sb.append('1');
      } else {
        sb.append('0');
      }
    }

    if (n > 0) {
      for (int i = sb.length() - 1; i > 0 && n > 0; i--) {
        if (sb.charAt(i) == '0') {
          n--;
          sb.setCharAt(i, '1');
        }
      }
    }

    while (n-- > 0) {
      sb.append('1');
    }

    return Integer.parseInt(sb.toString(), 2);
  }
}
