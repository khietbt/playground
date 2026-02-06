function countPalindromicSubsequence(s: string): number {
  let total = 0;

  for (let i = 0; i < 26; i++) {
    let c = String.fromCharCode(97 + i);

    let left = s.indexOf(c);
    let right = s.lastIndexOf(c);

    let characters = new Set();

    for (let i = left + 1; i < right; i++) {
      characters.add(s[i]);
    }

    total += characters.size;
  }

  return total;
};

console.log(countPalindromicSubsequence("aabca"));
