function maxVowels(s: string, k: number): number {
  const evaluate = c => "aoeiu".indexOf(c) < 0 ? 0 : 1;

  const length = s.length;

  let max = 0;

  for (let i = 0; i < k; i++) {
    max += evaluate(s[i]);
  }

  let current = max;
  console.log(`current=${current}, max=${max}`);

  for (let i = k; i < length && max < k; i++) {
    console.log(`current=${current}, max=${max}`);
    current = current + evaluate(s[i]) - evaluate(s[i - k]);
    max = Math.max(current, max);
    console.log(`current=${current}, max=${max}`);
  }


  return max;
};

console.log(maxVowels("leetcode", 3))
