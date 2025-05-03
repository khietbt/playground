function sumZero(n: number): number[] {
  if (n === 0) {
    return [];
  }

  const results = Array.from({ length: n }, (_, i) => i);

  results[0] = - n * (n - 1) / 2;

  return results;
};

console.log(sumZero(5));
