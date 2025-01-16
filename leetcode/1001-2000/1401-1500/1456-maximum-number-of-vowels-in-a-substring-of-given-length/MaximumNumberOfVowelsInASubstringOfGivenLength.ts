function maxVowels(s: string, k: number): number {
  const evaluate = (c: string): number => "aoeiu".indexOf(c) < 0 ? 0 : 1;

  const length = s.length;

  let max = 0;

  for (let i = 0; i < k; i++) {
    max += evaluate(s[i]);
  }

  let current = max;

  for (let i = k; i < length && max < k; i++) {
    current = current + evaluate(s[i]) - evaluate(s[i - k]);
    max = Math.max(current, max);
  }


  return max;
};

console.log(maxVowels("leetcode", 3))
