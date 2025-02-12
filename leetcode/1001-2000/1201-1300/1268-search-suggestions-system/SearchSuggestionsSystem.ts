class Trie {
  children: (Trie | null)[];
  indices: number[];

  constructor() {
    this.children = new Array(26).fill(null);
    this.indices = [];
  }

  populate(s: string, index: number) {
    let trie: Trie = this;

    for (let i = 0; i < s.length; i++) {
      const c = s.charCodeAt(i) - 'a'.charCodeAt(0);

      const child = trie.children[c] ?? new Trie();

      if (child.indices.length < 3) {
        child.indices.push(index);
      }

      trie.children[c] = child;

      trie = child;
    }
  }

  search(s: string): number[][] {
    let trie: Trie = this;
    const answers: number[][] = [];

    for (let i = 0; i < s.length; i++) {
      // const c = s[i];
      const c = s.charCodeAt(i) - 'a'.charCodeAt(0);

      // console.log(c, JSON.stringify(trie));

      if (trie == null || trie.children[c] == null) {
        return answers;
      }

      answers.push(trie.children[c].indices);

      trie = trie.children[c];
    }

    return answers;
  }
};

function suggestedProducts(products: string[], searchWord: string): string[][] {
  let trie: Trie | undefined | null = new Trie();
  products.sort((a, b) => a > b ? 1 : -1);
  products.forEach((p, i) => trie?.populate(p, i));

  // console.log(JSON.stringify(trie));

  const words = trie.search(searchWord).map(
    (indies) => indies.map(i => products[i])
  );

  while (words.length < searchWord.length) {
    words.push([]);
  }

  return words;
};

// console.log(suggestedProducts(["mo", "ma"], "mas"));
console.log(suggestedProducts(["mobile", "mouse", "moneypot", "monitor", "mousepad"], "mouse"));
