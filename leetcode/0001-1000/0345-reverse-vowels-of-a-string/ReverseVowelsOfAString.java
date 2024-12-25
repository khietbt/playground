import java.util.function.Function;

public class ReverseVowelsOfAString {
  public static void main(String[] args) {
    System.out.println(new Solution().reverseVowels("leetcode"));
    System.out.println(new Solution().reverseVowels("IceCreAm"));
  }
}

class Solution {
  public String reverseVowels(String s) {
    Function<Character, Boolean> isVowel = c -> "aeoiuAEOIU".indexOf(c) >= 0;

    char[] characters = s.toCharArray();

    for (int left = 0, right = characters.length - 1; left < right; left++, right--) {
      while (left < right && !isVowel.apply(characters[left])) {
        left++;
      }

      while (left < right && !isVowel.apply(characters[right])) {
        right--;
      }

      if (left < right) {
        char c = characters[left];
        characters[left] = characters[right];
        characters[right] = c;
      }
    }

    return String.valueOf(characters);
  }
}
