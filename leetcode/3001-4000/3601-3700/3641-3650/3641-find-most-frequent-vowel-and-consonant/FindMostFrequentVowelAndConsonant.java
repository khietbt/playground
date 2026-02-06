public class FindMostFrequentVowelAndConsonant {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.maxFreqSum("successes"));
  }
}

class Solution {
  public int maxFreqSum(String s) {
    var characters = new int[26];

    for (var c : s.toCharArray()) {
      characters[c - 'a']++;
    }

    var max1 = 0;
    var max2 = 0;

    for (var i = 0; i < 26; i++) {
      switch (i + 'a') {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
          max1 = Math.max(max1, characters[i]);
          break;
        default:
          max2 = Math.max(max2, characters[i]);
          break;
      }
    }

    return max1 + max2;
  }
}
