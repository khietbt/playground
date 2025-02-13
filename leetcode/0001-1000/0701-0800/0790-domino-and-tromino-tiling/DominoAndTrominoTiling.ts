function numTilings(n: number): number {
  const divisor = 1_000_000_007;

  const d: number[] = [0, 1, 2, 5];

  if (n < 4) {
    return d[n];
  }

  while (n-- > 3) {
    const current = (2 * d[3] + d[1]) % divisor;

    d[0] = d[1];
    d[1] = d[2];
    d[2] = d[3];
    d[3] = current;
  }

  return d[3];
};

console.log(numTilings(10));
