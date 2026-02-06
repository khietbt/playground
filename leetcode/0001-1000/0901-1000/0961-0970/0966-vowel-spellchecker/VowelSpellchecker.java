import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class VowelSpellchecker {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.toString(
            solution.spellchecker(
                new String[] { "KiTe", "kite", "hare", "Hare" },
                new String[] { "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto" })));
  }
}

class Solution {
  public String[] spellchecker(String[] wordlist, String[] queries) {
    var exacts = new HashSet<String>();
    var lows = new HashMap<String, String>();
    var devoweleds = new HashMap<String, String>();

    for (var w : wordlist) {
      exacts.add(w);
      lows.putIfAbsent(w.toLowerCase(), w);
      devoweleds.putIfAbsent(w.toLowerCase().replaceAll("[aeiou]", "_"), w);
    }

    var answers = new ArrayList<String>();

    for (var q : queries) {
      if (exacts.contains(q)) {
        answers.add(q);
        continue;
      }

      q = q.toLowerCase();

      if (lows.containsKey(q)) {
        answers.add(lows.get(q));
        continue;
      }

      q = q.replaceAll("[aeiou]", "_");

      if (devoweleds.containsKey(q)) {
        answers.add(devoweleds.get(q));
        continue;
      }

      answers.add("");
    }

    return answers.toArray(new String[0]);
  }
}
