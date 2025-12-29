function countNegatives(grid: number[][]): number {
  let totalNegatives = 0;

  let right = grid[0].length;

  for (let i = 0; i < grid.length; i++) {
    let left = 0;

    while (left < right) {
      const middle = Math.floor((left + right) / 2);

      if (grid[i][middle] < 0) {
        right = middle;
      } else {
        left = middle + 1;
      }
    }

    totalNegatives += grid[0].length - right;
  }

  return totalNegatives;
}

console.log(
  countNegatives([
    [4, 3, 2, -1],
    [3, 2, 1, -1],
    [1, 1, -1, -2],
    [-1, -1, -2, -3],
  ]),
);

console.log(
  countNegatives([
    [3, 2],
    [1, 0],
  ]),
);
