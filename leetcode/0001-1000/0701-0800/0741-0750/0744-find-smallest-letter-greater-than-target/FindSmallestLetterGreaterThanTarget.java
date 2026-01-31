public class FindSmallestLetterGreaterThanTarget {

  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(
    // solution.nextGreatestLetter(
    // new char[] { 'c', 'f', 'j' },
    // 'a'));

    System.out.println(
        solution.nextGreatestLetter(
            new char[] { 'c', 'f', 'j' },
            'c'));
  }
}

class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    var n = letters.length;
    var smallest = letters[n - 1];

    if (smallest <= target) {
      return letters[0];
    }

    for (var i = letters.length - 2; i >= 0 && letters[i] > target; i--) {
      smallest = (char) Math.min(letters[i], smallest);
    }

    return smallest;
  }
}
