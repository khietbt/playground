function vowelStrings(words: string[], queries: number[][]): number[] {
  const vowels = "aoeiu";
  const isVowel = (c: string): boolean => vowels.indexOf(c) >= 0;
  const startsAndEndsWithVowel = (s: string): boolean => s.length > 0 && isVowel(s[0]) && isVowel(s[s.length - 1]);
  const evaluated = words.map(w => startsAndEndsWithVowel(w) ? 1 : 0);
  const accumulated = new Array(evaluated.length + 1).fill(0);

  evaluated.forEach((v, i) => accumulated[i + 1] = accumulated[i] + v);

  return queries.map(q => accumulated[q[1] + 1] - accumulated[q[0]]);
};

console.log(vowelStrings(["aba", "bcb", "ece", "aa", "e"], [[0, 2], [1, 4], [1, 1]]));
