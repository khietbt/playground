class Trie {
  Trie[] children;
  boolean endOfWord;

  public Trie() {
    children = new Trie[26];
    endOfWord = false;
  }

  public void insert(String word) {
    Trie currentNode = this;

    for (char c : word.toCharArray()) {
      int index = c - 'a';

      if (children[index] == null) {
        children[index] = new Trie();
      }

      currentNode = currentNode.children[index];
    }

    currentNode.endOfWord = true;
  }

  public boolean search(String word) {
    Trie currentNode = this;

    for (char c : word.toCharArray()) {
      int index = c - 'a';

      if (currentNode.children[index] == null) {
        return false;
      }

      currentNode = currentNode.children[index];
    }

    return currentNode != null && currentNode.endOfWord;
  }

  public boolean startsWith(String prefix) {
    Trie currentNode = this;

    for (char c : prefix.toCharArray()) {
      int index = c - 'a';

      if (currentNode.children[index] == null) {
        return false;
      }

      currentNode = currentNode.children[index];
    }

    return currentNode != null;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
