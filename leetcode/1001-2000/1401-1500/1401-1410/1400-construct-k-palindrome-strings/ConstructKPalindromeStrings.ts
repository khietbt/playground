function canConstruct(s: string, k: number): boolean {
  if (s.length < k) {
    return false;
  }

  let totalOddCharacters = 0;

  const characters: number[] = new Array(26).fill(0);

  const a = "a".codePointAt(0)!;

  for (let i = 0; i < s.length; i++) {
    characters[s.codePointAt(i)! - a]++;
  }

  for (let i = 0; i < characters.length; i++) {
    totalOddCharacters += characters[i] % 2;
  }

  return totalOddCharacters <= k;
};

console.log(canConstruct("annabelle", 2));

