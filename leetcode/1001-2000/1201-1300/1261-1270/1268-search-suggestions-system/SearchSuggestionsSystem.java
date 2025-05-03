import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
  public static void main(String[] args) {
    String[] products = new String[] {
        "mobile", "mouse", "moneypot", "monitor", "mousepad"
    };

    String searchWord = "mouses";

    System.out.println(new Solution().suggestedProducts(products, searchWord));
  }
}

class Trie {
  Trie[] children;
  List<Integer> indices;

  public Trie() {
    children = new Trie[26];
    indices = new ArrayList<>();
  }

  public void populate(String word, int wordIndex) {
    Trie trie = this;

    for (char c : word.toCharArray()) {
      int i = c - 'a';

      if (trie.children[i] == null) {
        trie.children[i] = new Trie();
      }

      if (trie.children[i].indices.size() < 3) {
        trie.children[i].indices.add(wordIndex);
      }

      trie = trie.children[i];
    }
  }

  public List<List<Integer>> search(String word) {
    List<List<Integer>> answers = new ArrayList<>();

    Trie trie = this;

    for (char c : word.toCharArray()) {
      int index = c - 'a';

      if (trie == null || trie.children[index] == null) {
        return answers;
      }

      answers.add(trie.children[index].indices);

      trie = trie.children[index];
    }

    return answers;
  }
};

class Solution {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();

    Arrays.sort(products);

    for (int i = 0; i < products.length; i++) {
      trie.populate(products[i], i);
    }

    List<List<Integer>> indices = trie.search(searchWord);
    List<List<String>> answers = new ArrayList<>();

    for (List<Integer> integers : indices) {
      List<String> l = new ArrayList<>();
      for (Integer i : integers) {
        l.add(products[i]);
      }

      answers.add(l);
    }

    while (answers.size() < searchWord.length()) {
      answers.add(new ArrayList<>());
    }

    return answers;
  }
}
