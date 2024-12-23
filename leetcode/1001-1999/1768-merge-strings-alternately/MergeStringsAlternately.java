public class MergeStringsAlternately {
  public static void main(String[] args) {
    System.out.println((new Solution()).mergeAlternately("abc", "pqr"));
  }
}

class Solution {
  public String mergeAlternately(String word1, String word2) {
    int l = Math.min(word1.length(), word2.length());

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < l; i++) {
      sb.append(word1.charAt(i));
      sb.append(word2.charAt(i));
    }

    return sb.append(word1.substring(l)).append(word2.substring(l)).toString();
  }
}
