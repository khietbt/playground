function new21Game(n: number, k: number, maxPts: number): number {
  if (n >= k + maxPts) {
    return 1;
  }

  const data: number[] = new Array(n + 1).fill(0);

  data[0] = 1;

  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= maxPts; j++) {
      if (i - j >= 0 && i - j < k) {
        data[i] += data[i - j] / maxPts;
      }
    }
  }

  var total = 0;

  for (let i = k; i <= n; i++) {
    total += data[i];
  }

  return total;
}

// console.log(new21Game(10, 1, 10));
//
// console.log(new21Game(6, 1, 10));

console.log(new21Game(21, 17, 10));
