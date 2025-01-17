function equalPairs(grid: number[][]): number {
  const n = grid.length;

  const equals = (row: number, column: number) => {
    for (let i = 0; i < n; i++) {
      const cr: number = grid[row][i];
      const cl: number = grid[i][column];

      if (cr !== cl) {
        return false;
      }
    }

    return true;
  }

  let totalEqualPairs = 0;

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      totalEqualPairs += equals(i, j) ? 1 : 0;
    }
  }

  return totalEqualPairs;
};

console.log(equalPairs([[3, 1, 2, 2], [1, 4, 4, 5], [2, 4, 2, 2], [2, 4, 2, 2]]))
