function countBits(n: number): number[] {
  const answers: number[] = new Array(n + 1);
  answers[0] = 0;

  for (let i = 1; i <= n; i++) {
    answers[i] = answers[i & (i - 1)] + 1;
  }

  return answers;
};

console.log(countBits(5));
console.log(countBits(31));
