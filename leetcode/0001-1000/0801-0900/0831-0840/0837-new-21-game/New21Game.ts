function new21Game(n: number, k: number, maxPts: number): number {
  if (k === 0) {
    return 1;
  }

  const data: number[] = new Array(n + 1).fill(0);

  data[0] = 1;

  let s = 1;

  for (let i = 1; i <= n; i++) {
    data[i] = s / maxPts;

    if (i < k) {
      s += data[i];
    }

    if (i < k + maxPts && i >= maxPts) {
      s -= data[i - maxPts];
    }
  }

  return data.filter((_, i) => i >= k).reduce((sum, v) => sum + v, 0);
}

// console.log(new21Game(10, 1, 10));
// console.log(new21Game(6, 1, 10));
console.log(new21Game(21, 17, 10));
