function maximumWealth(accounts: number[][]): number {
  return accounts.reduce((max, c) => {
    return Math.max(
      max,
      c.reduce((sum, v) => sum + v, 0),
    );
  }, -Number.MAX_SAFE_INTEGER);
}

console.log(
  maximumWealth([
    [1, 2, 3],
    [3, 2, 1],
  ]),
);

console.log(
  maximumWealth([
    [1, 5],
    [7, 3],
    [3, 5],
  ]),
);

console.log(
  maximumWealth([
    [2, 8, 7],
    [7, 1, 3],
    [1, 9, 5],
  ]),
);
