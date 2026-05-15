function countGoodSubstrings(s: string): number {
  let totalGoodSubstrings = 0;

  for (let i = 0; i < s.length - 2; i++) {
    const a = s[i];
    const b = s[i + 1];
    const c = s[i + 2];

    if (a !== b && b !== c && c !== a) {
      totalGoodSubstrings++;
    }
  }

  return totalGoodSubstrings;
};
