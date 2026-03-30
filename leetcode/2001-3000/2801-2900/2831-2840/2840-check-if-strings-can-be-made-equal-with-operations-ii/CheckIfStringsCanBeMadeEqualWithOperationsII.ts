function checkStrings(s1: string, s2: string): boolean {
  const n = s1.length;

  const anagrams: number[] = new Array(52).fill(0);

  // 97 is char code of 'a'.
  for (let i = 0; i < n; i++) {
    anagrams[s1.charCodeAt(i) - 97 + (i % 2) * 26]++;
    anagrams[s2.charCodeAt(i) - 97 + (i % 2) * 26]--;
  }

  for (let i = 0; i < 52; i++) {
    if (anagrams[i] != 0) {
      return false;
    }
  }

  return true;
}

console.log(checkStrings("abcdba", "cabdab"));
