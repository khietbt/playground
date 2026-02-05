import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SortVowelsInAString {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.sortVowels("lEetcOde"));
  }
}

class Solution {
  public String sortVowels(String s) {
    var characters = s.toCharArray();
    var queue = new PriorityQueue<Character>();
    var vowels = new ArrayList<Integer>();

    var data = new TreeMap<Character, Integer>();

    data.put('A', 0);
    data.put('E', 0);
    data.put('I', 0);
    data.put('O', 0);
    data.put('U', 0);
    data.put('a', 0);
    data.put('e', 0);
    data.put('i', 0);
    data.put('o', 0);
    data.put('u', 0);

    for (var i = 0; i < s.length(); i++) {
      var index = i;
      data.computeIfPresent(s.charAt(i), (k, v) -> {
        vowels.add(index);
        return v + 1;
      });
    }

    for (var i = 0; i < vowels.size(); i++) {
      while (data.firstEntry().getValue() <= 0) {
        data.remove(data.firstKey());
      }

      characters[vowels.get(i)] = data.firstKey();
      data.compute(data.firstKey(), (k, v) -> v - 1);
    }

    return new String(characters);
  }
}
