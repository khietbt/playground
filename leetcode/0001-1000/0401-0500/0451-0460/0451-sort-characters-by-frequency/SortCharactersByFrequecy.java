import java.util.PriorityQueue;

public class SortCharactersByFrequecy {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.frequencySort("tree"));
  }
}

class Solution {
  public String frequencySort(String s) {
    var characters = new int[256];

    for (var i = 0; i < s.length(); i++) {
      characters[s.charAt(i)]++;
    }

    var queue = new PriorityQueue<Character>((a, b) -> {
      return characters[b] - characters[a];
    });

    for (var i = 0; i < 256; i++) {
      if (characters[i] > 0) {
        queue.offer((char) i);
      }
    }

    var sb = new StringBuilder();

    while (!queue.isEmpty()) {
      var c = (Character) queue.poll();

      sb.append(String.valueOf(c).repeat(characters[c]));
    }

    return sb.toString();
  }
}
