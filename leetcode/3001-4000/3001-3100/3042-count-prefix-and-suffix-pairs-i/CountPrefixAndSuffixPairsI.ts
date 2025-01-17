function countPrefixSuffixPairs(words: string[]): number {
  let totalPrefixSuffixParis = 0;

  for (let i = 0; i < words.length; i++) {
    for (let j = i + 1; j < words.length; j++) {
      if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
        totalPrefixSuffixParis++;
      }
    }
  }

  return totalPrefixSuffixParis;
};

console.log(countPrefixSuffixPairs(["a", "aba", "ababa", "aa"]));
console.log(countPrefixSuffixPairs(["abab", "ab"]));
